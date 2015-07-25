/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/

/*
inorder tree traversal
*/

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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode node = root;
        while(!st.isEmpty()){
            if(node!=null) {
                st.push(node);
                node = node.left;
            }
            else {
                node = st.pop();
                k--;
                if(k==0) return node.val;
                node = node.right;
            }
        }
        return -1;
    }
}
