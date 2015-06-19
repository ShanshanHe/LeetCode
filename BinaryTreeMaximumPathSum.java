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
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    
    int maxPathSum(TreeNode root, int[] max) {
        if(root == null ) return 0;
        int l = maxPathSum(root.left, max);
        int r = maxPathSum(root.right, max);
        int across = l + r + root.val;
        int tmpMax = Math.max(root.val, Math.max(l,r)+root.val);
        max[0] = Math.max(max[0], Math.max(across, tmpMax));
        return tmpMax;
    }
}
