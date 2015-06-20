public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length-1, target);
    }
    
    int searchInsert(int[] nums, int l, int r, int target) {
        if(l>r) return l;
        int mid = (l + r) / 2;
        if(target == nums[mid]) return mid;
        else if(target < nums[mid]) return searchInsert(nums, l, mid-1, target);
        else return searchInsert(nums, mid+1, r, target);
    }
}
