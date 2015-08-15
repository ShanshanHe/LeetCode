/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

/*
Dynamic Programming
There are two cases here 1) 1st element is included and last is not included 2) 1st is not included and last is included. Therefore, we can use the similar dynamic programming approach for 'House Robber' to scan the array twice and get the larger value.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        // doesn't rob the last store
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < nums.length; ++i){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        
        // doesnt rob the first one
        int[] df = new int[nums.length];
        df[0] = 0;
        df[1] = nums[1];
        for(int i = 2; i < nums.length; ++i){
            df[i] = Math.max(df[i-2]+nums[i], df[i-1]);
        }
        
        return Math.max(dp[nums.length-1], df[nums.length-1]);
    }
}
