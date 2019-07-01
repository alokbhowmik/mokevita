import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class Demo {
    static boolean is_opening_bracket(char s){
        if (s=='{'||s=='[' ||s=='(') {
            return true;
        }
        return false;
    }
    static boolean is_star(char s){
        if(s=='*'){
            return true;
        }
        return false;
    }
    
    static boolean is_closing_bracket(char s){
        if (s==']' || s==')' || s=='}') {
            return true;
        }return false;
    }
    static boolean is_integer(String s){
        try {
            Integer.parseInt(s);
            return  true;
        } catch (Exception e) {
            
            return false;
        }
    }
    public static void main(String[] args) {
        int yes_pair=0,no_pair=0;
        Map<Character,Character>map = new HashMap<Character,Character>();
        map.put( '}','{');
        map.put( ']','[');
        map.put( ')','(');

        //-----------------------------------------declear stack--------------------------------------
        Stack<Character> stk = new Stack();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch[]=str.toCharArray();
        int c=0;
        int total_star =-1;
        char top_character_in_stack ;

        for (int i = 0; i < str.length(); i++) {
            char s = ch[i];
            if (is_opening_bracket(s)) {
                if (c!=0) {
                    char chr=Character.forDigit(c, 10);
                    
                    stk.add(chr);
                    c=0;
                }
                stk.add(s);
            } else if(is_star(s)){
                c++;   
            }else if(is_closing_bracket(s)){
                if (c!=0) {
                    char chr=Character.forDigit(c, 10);
                    
                    stk.add(chr);
                    c=0;
                }
                try{top_character_in_stack=stk.pop();
                    total_star= is_integer(""+top_character_in_stack)?Character.getNumericValue(top_character_in_stack):-1;
                }catch(EmptyStackException ese){}
                if (total_star!=-1) {
                    try {
                        
                        if ( total_star%2==0) {
                            
                            if (stk.isEmpty()==true) {
                                no_pair++;
                                
                            } 
                            else if(map.get(s)!=stk.peek()){no_pair++;}
                            else{yes_pair++;}
                            
                        }
                        
                        stk.pop();
                    } catch (Exception e) {}
                    
                } 
            }
        }

        System.out.println(no_pair!=0?"No "+no_pair:"Yes "+yes_pair);
       
    }
}