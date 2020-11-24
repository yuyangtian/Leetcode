package Greedy;
/*
55. 跳跃游戏 medium 81 71
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
通过次数172,015提交次数415,928
 */
import java.util.HashSet;
import java.util.Set;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        int destination = nums.length-1;
        hashset.add(destination);
        int count=0;
        for(int i=0;i<destination;i++){
            if(nums[i]==1)
                count++;
            else
                break;
        }
        if(count==destination)
            return true;
        if(destination>1000)
            return false;
        for(int location=destination-1;location>=0;location--){
            for(int i=destination;i>0;i--){
                if(hashset.contains(i)){
                    if(CanReach(location,i,nums)){
                        hashset.add(location);
                        break;
                    }
                }
            }
        }
        if(hashset.contains(0))
            return true;
        else
            return false;
    }
    public boolean CanReach(int l,int j,int[] arr){
        if(arr[l]>=j-l)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution_55 test = new Solution_55();
        int[] arr={2,1,0,0};
        System.out.println(test.canJump(arr));
    }
}

