package Greedy;
/*
944. 删列造序 easy 88 89
给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。

你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。

删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。（可以参见 删除操作范例）



示例 1：

输入：["cba", "daf", "ghi"]
输出：1
解释：
当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
示例 2：

输入：["a", "b"]
输出：0
解释：D = {}
示例 3：

输入：["zyx", "wvu", "tsr"]
输出：3
解释：D = {0, 1, 2}


提示：

1 <= A.length <= 100
1 <= A[i].length <= 1000
 */
public class Solution_944 {
    public int minDeletionSize(String[] A) {
        int StringLength = A[0].length();
        int result=0;
        for(int i=0;i<StringLength;i++){
           for(int j=0;j<A.length-1;j++){
               if(A[j].charAt(i)>A[j+1].charAt(i)){
                   result++;
                   break;
               }
           }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_944 test = new Solution_944();
        String[] a ={"cba", "daf", "ghi"};
        System.out.println(test.minDeletionSize(a));
    }
}
