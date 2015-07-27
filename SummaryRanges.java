/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

/*
use two cursor "start" and "end" to track the range
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(i+1 < nums.length && (nums[i+1] - nums[i]) == 1) continue;
            else{
                String str;
                if(i>start) str = nums[start]+"->"+nums[i];
                else str = Integer.toString(nums[start]);
                res.add(str);
                start = i+1;
            }
        }
        return res;
    }
}
