public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 0 ) return 1;
        for(int i = 0; i < n; ) {
            if(0 < nums[i] && nums[i] < n && nums[i] != i && nums[nums[i]] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            else i++;
        }
        for(int i = 1; i < n; i++) {
            if(nums[i] != i) return i;
        }
        return nums[0] == n ? n+1 : n;
    }
}
