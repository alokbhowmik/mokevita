import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Demo
 */
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
            //TODO: handle exception
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
                    // System.out.println(chr);
                    stk.add(chr);
                    c=0;
                }
                stk.add(s);
            } else if(is_star(s)){
                c++;   
            }else if(is_closing_bracket(s)){
                if (c!=0) {
                    char chr=Character.forDigit(c, 10);
                    // System.out.println(chr);
                    stk.add(chr);
                    c=0;
                }
                try{top_character_in_stack=stk.pop();
                    total_star= is_integer(""+top_character_in_stack)?Character.getNumericValue(top_character_in_stack):-1;
                }catch(EmptyStackException ese){}
                
                // System.out.println(total_star);
                // System.out.println(s);
                
                if (total_star!=-1) {
                    try {
                        // System.out.println(total_star);
                        if ( total_star%2==0) {
                            // System.out.println(stk.isEmpty());
                            if (stk.isEmpty()==true) {
                                // yes_pair++;
                                no_pair++;
                                // System.out.println(no_pair);
                            } 
                            else if(map.get(s)!=stk.peek()){no_pair++;}
                            else{yes_pair++;}
                            
                        }
                        
                        stk.pop();
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    
                } 
            }
        }

        System.out.println(no_pair!=0?"No "+no_pair:"Yes "+yes_pair);
        // System.out.println(yes_pair);
        // System.out.println(no_pair);
        // [{, (, 2, {, 2, [, 2]
        // System.out.println(stk);
        // System.out.println("##########################################");
        // System.out.println(total_star);
        // System.out.println(is_integer(""+stk.get(index))?"Success":"Failure");
    }
}