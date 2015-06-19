public class Solution {
    public void sortColors(int[] nums) {
        // algorithm 1: counting sort, count the number of 0s, 1s and 2s and then overwrite the array
        // algorithm 2: set two index: red and blue, starting from the start and end of the array
        int n = nums.length;
        int red = 0, blue = n-1;
        for(int i = 0; i <= blue; ) {
            if(nums[i] == 0) {
                int tmp = nums[red];
                nums[red++] = nums[i];
                nums[i] = tmp;
                i++;
            }
            else if(nums[i] == 2) {
                int tmp = nums[blue];
                nums[blue--] = nums[i];
                nums[i] = tmp;
            }
            else i++;
        }
    }
}
