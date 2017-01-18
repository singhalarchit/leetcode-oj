/*

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

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
    
    private static int maxsum;
    
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        int x = util(root);
        return maxsum;
    }
    
    // util gives max length of path including root
    private int util(TreeNode root){
        
        if(root==null)
            return 0;
        int left = util(root.left);
        int right = util(root.right);
        int sum = root.val + left + right;
        maxsum = Math.max(maxsum, sum);
        return Math.max(0, root.val + Math.max(left,right));
    }
    
    
    
}