package Stack;
/*
844. 比较含退格的字符串
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。

 

示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/backspace-string-compare
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.Stack;

public class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        int index = 0;
        int result = 0;
        while(true){
            if(index<S.length()){
                if(S.charAt(index)=='#'){
                    if(!s1.isEmpty())
                        s1.pop();
                }
                else
                    s1.add(S.charAt(index));
            }
            if(index<T.length()){
                if(T.charAt(index)=='#'){
                    if(!s2.isEmpty())
                        s2.pop();
                }
                else
                    s2.add(T.charAt(index));
            }
            if(index>=S.length()&&index>=T.length()){
                break;
            }
            index++;
        }
        while(true){
            if(!s1.isEmpty()&&!s2.isEmpty()){
                if(s1.pop()!=s2.pop()){
                    result = 1;
                    break;
                }
                continue;
            }
            if(!s1.isEmpty()||!s2.isEmpty()){
                result = 1;
                break;
            }
            break;
        }
        if(result==1)
            return false;
        else return true;
    }
    public static void main(String[] args) {
        Solution_844 s = new Solution_844();
        String s1="xywrrmp";
        String s2="xywrrm#p";
        System.out.println(s.backspaceCompare(s1,s2));
    }
}


