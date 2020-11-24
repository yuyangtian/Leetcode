package Sort;
/*
349. 两个数组的交集 easy 16 46
给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hashSet.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hashSet.contains(nums2[i])){
                arr.add(nums2[i]);
                hashSet.remove(nums2[i]);
            }
        }
       int[] arr1 = arr.stream().mapToInt(Integer::valueOf).toArray();
        return arr1;
    }
}
