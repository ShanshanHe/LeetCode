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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumNumbers(root, 0);
    }
    
    int sumNumbers(TreeNode root, int sum) {
        if( root == null ) return 0;
        if( root.left == null && root.right == null ) return sum*10 + root.val;
        return sumNumbers(root.left, sum*10 + root.val) + sumNumbers(root.right, sum*10 + root.val);
    }
}
