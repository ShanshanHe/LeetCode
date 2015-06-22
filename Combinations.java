public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0) return res;
        helper(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }
    
    void helper(int n, int k, int pos, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = pos; i <= n; i++) {
            curr.add(i);
            helper(n, k, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
