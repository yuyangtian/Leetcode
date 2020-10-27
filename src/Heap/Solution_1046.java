package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
easy 44 99时间复杂度较高

题解：
解题思路
1. 建立一个大根堆。
2. 从中选出两块 最重的 石头。
3. 新的石头重量写入 priorityQueue
4. priorityQueue空则return 0 否则返回队首元素。
提示：
1 <= stones.length <= 30
1 <= stones[i] <= 1000

补课： 剑指 Offer 40. 最小的k个数 -Java -大根堆

代码

import java.util.*;
class Solution {
    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1,1};
        int res = (new Solution()).lastStoneWeight(stones);
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        // 建立一个大根堆。
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.offer(stones[i]);
        }
        // 从中选出两块 最重的 石头
        while( priorityQueue.size() > 1 ) {
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            // 新的石头重量写入 priorityQueue
            int diff = y - x;
            if ( diff != 0 ) priorityQueue.offer(diff);
        }
        // priorityQueue空 return 0
        if ( priorityQueue.size() == 0 ) return 0;

        return priorityQueue.peek();
    }
}

作者：FlagMain
链接：https://leetcode-cn.com/problems/last-stone-weight/solution/1046-zui-hou-yi-kuai-shi-tou-de-zhong-liang-java-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

1046. 最后一块石头的重量
有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

示例：
输入：[2,7,4,1,8,1]
输出：1
解释：
先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。

提示：
1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */
public class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> bp = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int x:stones){
            bp.add(x);
        }
        while(!bp.isEmpty())
            if(bp.size()==1)
                return bp.peek();
            else{
                int mn = bp.remove();
                int n = bp.remove();
                if(mn==n)
                    continue;
                else
                    bp.add(mn-n);
            }
        return 0;
    }

    public static void main(String[] args) {
        Solution_1046 test = new Solution_1046();
        int[] arr = {2,7,4,1,8,1};
        System.out.println(test.lastStoneWeight(arr));
    }
}
