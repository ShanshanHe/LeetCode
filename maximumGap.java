/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        int N = nums.length;
        for(int i = 1; i < N; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        /*
        ** Bucket Sort
        ** N number will split the range [min,max] into N-1 small ranges.
        ** Math.ceil((max-min)/(N-1)): min of the maximum gap; when N number are evenly spaced
        ** the bucket size could not be larger than it
        ** because if it is, then it's possible that 
        ** the two number with maximum gap be put into the sampe bucket
        ** We put the N number into those buckets
        ** update the maxGap with the minVal of one buckets minus the maxVal of it's previous bucket
        */
        int bsize = (int)Math.ceil(((double)(max-min))/(N-1)); // size of the bucket
        int bnum = (max-min)/bsize+1; // number of buckets
        
        int[] minB = new int[bnum];
        int[] maxB = new int[bnum];
        Arrays.fill(minB, Integer.MAX_VALUE);
        Arrays.fill(maxB, Integer.MIN_VALUE);
        
        for(int i = 0; i < N; ++i) {
            int index = (nums[i]-min)/bsize;
            minB[index] = Math.min(minB[index],nums[i]);
            maxB[index] = Math.max(maxB[index],nums[i]);
        }
        
        // there might be empty bucket
        int maxGap = 0;
        int prev = maxB[0];
        for(int i = 1; i < bnum; ++i) {
            if(minB[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(minB[i]-prev, maxGap);
            prev = maxB[i];
        }
        return maxGap;
    }
}
