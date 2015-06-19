public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur_m = m - 1, cur_n = n - 1, cur_t = m + n - 1;
        while( cur_m >= 0 && cur_n >= 0 ) nums1[cur_t--] = nums1[cur_m] >= nums2[cur_n] ? nums1[cur_m--] : nums2[cur_n--];
        while( cur_n >= 0 ) nums1[cur_t--] = nums2[cur_n--];
    }
}
