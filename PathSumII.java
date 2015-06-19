/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        pathSum(root,sum,curr,res);
        return res;
    }
    
    void pathSum(TreeNode root, int sum, ArrayList<Integer> curr, List<List<Integer>> res) {
        if(root == null) return;
        if(root.val == sum && root.left == null && root.right == null) {
            curr.add(root.val);
            res.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        curr.add(root.val);
        pathSum(root.left, sum-root.val, curr, res);
        pathSum(root.right, sum-root.val, curr, res);
        curr.remove(curr.size()-1);
    }
}
