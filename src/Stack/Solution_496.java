package Stack;

import java.util.ArrayList;
/*
用时仅击败5％，需要使用单调栈
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack < Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}

方法一：单调栈
我们可以忽略数组 nums1，先对将 nums2 中的每一个元素，求出其下一个更大的元素。随后对于将这些答案放入哈希映射（HashMap）中，再遍历数组 nums1，并直接找出答案。对于 nums2，我们可以使用单调栈来解决这个问题。

我们首先把第一个元素 nums2[1] 放入栈，随后对于第二个元素 nums2[2]，如果 nums2[2] > nums2[1]，那么我们就找到了 nums2[1] 的下一个更大元素 nums2[2]，此时就可以把 nums2[1] 出栈并把 nums2[2] 入栈；如果 nums2[2] <= nums2[1]，我们就仅把 nums2[2] 入栈。对于第三个元素 nums2[3]，此时栈中有若干个元素，那么所有比 nums2[3] 小的元素都找到了下一个更大元素（即 nums2[3]），因此可以出栈，在这之后，我们将 nums2[3] 入栈，以此类推。

可以发现，我们维护了一个单调栈，栈中的元素从栈顶到栈底是单调不降的。当我们遇到一个新的元素 nums2[i] 时，我们判断栈顶元素是否小于 nums2[i]，如果是，那么栈顶元素的下一个更大元素即为 nums2[i]，我们将栈顶元素出栈。重复这一操作，直到栈为空或者栈顶元素大于 nums2[i]。此时我们将 nums2[i] 入栈，保持栈的单调性，并对接下来的 nums2[i + 1], nums2[i + 2] ... 执行同样的操作。

复杂度分析

时间复杂度：O(M+N)O(M+N)，其中 MM 和 NN 分别是数组 nums1 和 nums2 的长度。

空间复杂度：O(N)O(N)。我们在遍历 nums2 时，需要使用栈，以及哈希映射用来临时存储答案。

作者：LeetCode
链接：https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class Solution_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int i =0;i<nums1.length;i++){
            int monitor = 0;
            for(int j = 0;j<nums2.length;j++){
                if(nums2[j]==nums1[i])
                    monitor = 1;
                if(nums2[j]>nums1[i]){
                    if(monitor==1)
                        monitor = 2;
                    else
                        continue;
                    r.add(nums2[j]);
                    break;
                }
            }
            if(monitor==1)
                r.add(-1);
        }
        int[] d = new int[r.size()];
        for(int i = 0;i<r.size();i++){
            d[i] = r.get(i);
        }
        return d;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        Solution_496 t = new Solution_496();
        int[] r = t.nextGreaterElement(nums1,nums2);
        for(int x : r){
            System.out.println(x);
        }
    }

}
