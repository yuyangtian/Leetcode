public class Solution_20 {
    class stack{
        private char[] s = new char[10000];
        private int index = 0;
        public void push(char c){
            s[index] = c;
            index++;
        }
        public char pop(){
            char c = s[index-1];
            index--;
            return c;
        }
    }
    public boolean isValid(String s) {
        stack sk = new stack();
        int length = s.length();
        if(length==0)return true;
        else
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                sk.push(s.charAt(i));
            }
            if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(sk.index<1)
                    return false;
                char c1 = sk.pop();
                if(c1=='(')
                    if(s.charAt(i)!=')')
                        return false;
                if(c1=='[')
                    if(s.charAt(i)!=']')
                        return false;
                if(c1=='{')
                    if(s.charAt(i)!='}')
                        return false;
            }
        }
        if(sk.index==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution_20 s = new Solution_20();
        if(s.isValid("]"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
