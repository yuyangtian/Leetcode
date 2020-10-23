package Stack;
/*
1021. 删除最外层的括号
时间9 空间52
时空复杂度均较高

题解如下：
思路：遍历字符串，遇到左括号就入栈，遇到右括号就出栈，每次栈空的时候，都说明找到了一个原语，记录下每个原语的起始位置和结束位置，取原字符串在原语的起始位置+1到原语的结束位置的子串便得到原语删除了最外层括号的字符串，拼接，即可解出答案。

详细代码+注释：
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;// 初始化原语的起始位置
        int end = 0;// 初始化原语的结束位置
        boolean flag = false;// 标志每个原语

        for (int i = 0;i < S.length();i++) {
            char ch = S.charAt(i);

            if (ch == '(') {// 遇到左括号，入栈
                stack.push(ch);
                if (!flag) {// 遇到的第一个左括号，是原语的开始位置，记录下原语开始位置
                    start = i;
                    flag = true;
                }
            }

            if (ch == ')') {// 遇到右括号，出栈
                stack.pop();
                if (stack.isEmpty()) {// 当栈空的时候，找到了一个完整的原语
                    end = i;// 记录下结束位置
                    ans.append(S.substring(start + 1,end));// 去掉原语的最外层括号，并追加到答案中
                    flag = false;// 置标志为false，往后接着找下一个原语
                    start = end;// 往后找，再次初始化原语开始位置
                }
            }
        }

        return ans.toString();
    }
}

作者：zi-mo-10
链接：https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/chao-xiang-xi-ti-jie-si-lu-jie-zhu-zhan-yuan-yu-hu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

1021. 删除最外层的括号
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。



示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。


提示：

1.S.length <= 10000
2.S[i] 为 "(" 或 ")"
3.S 是一个有效括号字符串
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_1021 {
    Stack<Character> s1 = new Stack<Character>();
    Queue<Character> s2 = new LinkedList<Character>() {
    };
    public String removeOuterParentheses(String S) {
        String result="";
        int count = 0;
        while(true){
            int index = 0;
            while(true){
                char c = S.charAt(count);
                if(c=='('){
                    index++;
                    count++;
                    s1.push(c);
                    s2.add(c);
                }
                else{
                    index++;
                    count++;
                    s2.add(c);
                    s1.pop();
                    if(s1.isEmpty())
                        break;

                }
            }
            s2.remove();
            index--;
            for(;index>1;index--){
                /*if(s2.remove()=='('){
                    result+=')';
                }
                else
                    result+='(';
                    */
                 result += s2.remove();
            }
            s2.remove();
            if(count==S.length())
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        Solution_1021 a = new Solution_1021();
        System.out.println(a.removeOuterParentheses(s));
    }
}
