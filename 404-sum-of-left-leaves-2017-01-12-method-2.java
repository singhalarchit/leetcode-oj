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
    public int sumOfLeftLeaves(TreeNode root) {
        
        // if root is null or root is leaf node, return 0
        if(root==null || (root.left==null && root.right==null))
            return 0;
        // if root has its left child as a leaf node
        if(root.left !=null && root.left.left==null && root.left.right==null)
            return root.left.val + sumOfLeftLeaves(root.right);
        // if left child is not a leaf
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}