public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        searchRange(nums, target, 0, nums.length-1, res);
        return res;
    }
    
    void searchRange(int[] nums, int target, int l, int r, int[] res) {
        if(l > r) return;
        if(nums[l] == nums[r] && nums[l] == target) {
            res[0] = res[0] == -1 ? l : Math.min(res[0], l);
            res[1] = Math.max(res[1], r);
            return;
        }
        int mid = (l + r) / 2;
        if(target < nums[mid]) searchRange(nums, target, l, mid-1, res);
        else if(target > nums[mid]) searchRange(nums, target, mid+1, r, res);
        else {
            res[0] = res[0] == -1 ? mid : Math.min(res[0], mid);
            res[1] = Math.max(res[1], mid);
            searchRange(nums, target, l, mid-1, res);
            searchRange(nums, target, mid+1, r, res);
        }
    }
}
