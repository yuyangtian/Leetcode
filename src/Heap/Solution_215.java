/*
215. 数组中的第K个最大元素 easy 51 90 时间复杂度高
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

题解：基于堆排序的选择方法

思路和算法
我们也可以使用堆排序来解决这个问题——建立一个大根堆，做 k - 1k−1 次删除操作后堆顶元素就是我们要找的答案。在很多语言中，
都有优先队列或者堆的的容器可以直接使用，但是在面试中，面试官更倾向于让更面试者自己实现一个堆。所以建议读者掌握这里大根堆的实现方法，
在这道题中尤其要搞懂「建堆」、「调整」和「删除」的过程。

友情提醒：「堆排」在很多大公司的面试中都很常见，不了解的同学建议参考《算法导论》或者大家的数据结构教材，一定要学会这个知识点哦! ^_^


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
复杂度分析

时间复杂度：O(n \log n)O(nlogn)，建堆的时间代价是 O(n)O(n)，删除的总代价是 O(k \log n)O(klogn)，因为 k < nk<n，故渐进时间复杂为 O(n + k \log n) = O(n \log n)O(n+klogn)=O(nlogn)。
空间复杂度：O(\log n)O(logn)，即递归使用栈空间的空间代价。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> lh = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int x:nums){
            lh.add(x);
        }
        while(k!=0){
            result = lh.remove();
            k--;
        }
        return result;
    }
}
