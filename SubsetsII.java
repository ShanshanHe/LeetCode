public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        res.add(curr);
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, res, curr);
        return res;
    }
    
    void subsetsWithDup(int[] nums, int pos, List<List<Integer>> res, List<Integer> curr) {
        for(int i = pos; i < nums.length; i++) {
            curr.add(nums[i]);
            res.add(new ArrayList<Integer>(curr));
            subsetsWithDup(nums, i+1, res, curr);
            curr.remove(curr.size()-1);
            while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
    }
}
