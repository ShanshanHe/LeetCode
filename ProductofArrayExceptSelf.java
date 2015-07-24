/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Solve it with constant space complexity. (output array doesn't count as extra space)
*/

/*
 input:      1|    1*2|  1*2*3|1*2*3*4
output:1*2*3*4|  2*3*4|    3*4|      4
then: output[i] = input[i-1]*output[i+1]
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        System.arraycopy(nums,0,res,0,nums.length);
        for(int i = 1; i < nums.length; i++) {
            nums[i] *= nums[i-1];
            res[nums.length-1-i] *= res[nums.length-i];
        }
        res[0] = res[1];
        for(int i = 1; i < res.length-1; i++) {
            res[i] = nums[i-1]*res[i+1];
        }
        res[res.length-1] = nums[res.length-2];
        return res;
    }
}
