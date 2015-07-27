/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
*/
/*
There are at most 2 possible majority elements.
Moore vote
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0) return res;
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int n1 = nums[0];
        int n2 = 0;
        int count1 = 1;
        int count2 = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == n1) count1++;
            else if(nums[i] == n2) count2++;
            else if(count1 == 0) {
                n1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                n2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == n1) count1++;
            else if(nums[i] == n2) count2++;
        }
        if(count1 > nums.length/3) res.add(n1);
        if(count2 > nums.length/3) res.add(n2);
        return res;
    }
}
