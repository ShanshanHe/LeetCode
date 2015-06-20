public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        res.add(curr);
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        subsets(nums, 0, res, curr);
        return res;
    }
    
    void subsets(int[] nums, int pos, List<List<Integer>> res, List<Integer> curr) {
        for(int i = pos; i < nums.length; i++) {
            curr.add(nums[i]);
            res.add(new ArrayList<Integer>(curr));
            subsets(nums, i+1, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}
