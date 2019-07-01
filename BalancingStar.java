import java.util.*;
class BalancingStar{
    // Map map = new 
    static int yes_pair=0;
    static int no_pair=0;
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
    public static void main(String[] args) throws Exception{
        Stack <Character>stk = new Stack();
        int c =0;
        int total_star=0;
        //-----------------------------------------------------------------------
        Map<Character,Character>map = new HashMap<Character,Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        //------------------------------------------------------------------------
        String str = "{**(**{**[**]})}";
        char input_array []=str.toCharArray();
        for (int i = 0; i < str.length();i++) {
            if (is_opening_bracket(input_array[i])) {
                stk.push(input_array[i]);
                if(c!=0){
                    stk.push((char)c);
                    c=0;
                }
            }
            if(is_star(input_array[i])){
                c++;
            }
            if (is_closing_bracket(input_array[i])) {
                if(c!=0){
                    stk.push((char)c);
                    c=0;
                }
                char ch = input_array[i];
                if (is_opening_bracket((Character)stk.peek()) ){
                    if (ch==map.get(stk.pop())) {
                        if(total_star%2==0){
                            yes_pair++;
                        }else{no_pair++;}
                        
                    } else {
                        no_pair++;
                    }
                }
                else{
                    // stk.pop();
                    // char val = (char)stk.pop();
                    total_star = Character.getNumericValue(stk.pop());
                    if (ch==map.get(stk.pop())) {
                        if(total_star%2==0){
                            yes_pair++;
                        }else{no_pair++;}
                        
                    } else {
                        no_pair++;
                    }
                }

            }
        }
        if(stk.isEmpty() && no_pair==0 ){
            System.out.println("Yes "+ yes_pair);
        }
        else{
            System.out.println("No "+no_pair);
        }
    }
}