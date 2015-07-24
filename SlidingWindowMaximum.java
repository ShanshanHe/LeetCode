/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
*/

/*
O(n) solution:
use Deque (Double Ended Queue) to stores only useful elements of current window of k elements. An element is useful if it's in current window and greater than all other elements on the left side of it in the current window. The elements stored in the deque are in a descending order.
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        if(k==1) return nums;
        int[] max = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]) dq.removeLast();
            dq.add(i);
        }
        max[0] = nums[dq.getFirst()];
        for(int i = 1; i < nums.length-k+1; i++) {
            while(!dq.isEmpty() && dq.getFirst()<i) dq.removeFirst();
            while(!dq.isEmpty() && nums[i+k-1]>=nums[dq.getLast()]) dq.removeLast();
            dq.add(i+k-1);
            max[i] = nums[dq.getFirst()];
        }
        return max;
    }
}
