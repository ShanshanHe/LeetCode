public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, curr, res);
        return res;
    }
    
    void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                curr.add(nums[i]);
                helper(nums, used, curr, res);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
    }
}
