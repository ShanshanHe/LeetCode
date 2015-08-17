/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

/*
We can track the maximum index that can be reached. The key to solve this problem is to find: 1) when the current position can not reach next position (return false) , and 2) when the maximum index can reach the end (return true).

The largest index that can be reached is: i + A[i].
*/

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int furthestPosition = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(furthestPosition < i) return false;
            furthestPosition = Math.max(furthestPosition, i+nums[i]);
        }
        if(furthestPosition < nums.length-1) return false;
        return true;
    }
}
