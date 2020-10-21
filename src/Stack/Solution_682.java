package Stack;

import java.util.Stack;
import java.util.concurrent.ConcurrentNavigableMap;
/*
用时仅击败23.9％，需要使用优化

方法：栈
思路与算法

让我们在处理数据时保持栈上每个有效回合的值。栈是理想的，因为我们只处理涉及最后或倒数第二轮的操作。



class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
}
复杂度分析

复杂度分析：O(N)O(N)，其中 NN 是 ops 的长度。我们解析给定数组中的每个元素，然后每个元素执行 O(1)O(1) 的工作。

空间复杂度：O(N)O(N)，用于存储 stack 的空间。

作者：LeetCode
链接：https://leetcode-cn.com/problems/baseball-game/solution/bang-qiu-bi-sai-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/*
你现在是棒球比赛记录员。
给定一个字符串列表，每个字符串可以是以下四种类型之一：
1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。

每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
你需要返回你在所有回合中得分的总和。

示例 1:

输入: ["5","2","C","D","+"]
输出: 30
解释:
第1轮：你可以得到5分。总和是：5。
第2轮：你可以得到2分。总和是：7。
操作1：第2轮的数据无效。总和是：5。
第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
第4轮：你可以得到5 + 10 = 15分。总数是：30。
示例 2:

输入: ["5","-2","4","C","D","9","+","+"]
输出: 27
解释:
第1轮：你可以得到5分。总和是：5。
第2轮：你可以得到-2分。总数是：3。
第3轮：你可以得到4分。总和是：7。
操作1：第3轮的数据无效。总数是：3。
第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
第5轮：你可以得到9分。总数是：8。
第6轮：你可以得到-4 + 9 = 5分。总数是13。
第7轮：你可以得到9 + 5 = 14分。总数是27。
注意：

输入列表的大小将介于1和1000之间。
列表中的每个整数都将介于-30000和30000之间。


 */
public class Solution_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        int sum_score=0;
        for(int i=0;i<ops.length;i++){
            if(ops[i].charAt(0)=='C'){
                int ban;
                ban = stack.pop();
                sum_score-=ban;
                System.out.println(sum_score);
                continue;
            }
            if(ops[i].charAt(0)=='D'){
                int x = 2*stack.peek();
                stack.add(x);
                sum_score+=x;
                System.out.println(sum_score);
                continue;
            }
            if(ops[i].charAt(0)=='+'){
                int high;
                int low;
                high = stack.pop();
                low = stack.pop();
                stack.add(low);
                stack.add(high);
                stack.add(high+low);
                sum_score+=stack.peek();
                System.out.println(sum_score);
                continue;
            }
            if(Integer.parseInt(ops[i])<=30000&&Integer.parseInt(ops[i])>=-30000){
                stack.add(Integer.parseInt(ops[i]));
                sum_score+=Integer.parseInt(ops[i]);
                System.out.println(sum_score);
            }
        }
        return sum_score;
    }

    public static void main(String[] args) {
        String[] test = {"5","-2","4","C","D","9","+","+"};
        Solution_682 p = new Solution_682();
        p.calPoints(test);
    }
}
