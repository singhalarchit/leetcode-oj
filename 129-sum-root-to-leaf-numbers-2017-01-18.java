/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

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
 
// The idea is to consider prevSum at each stage in the helper method

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int prevSum){
        
        
        if(root==null)
            return prevSum;
            
        int sum = prevSum*10+root.val;
        
        //If leaf node
        if(root.left == null && root.right == null)
            return sum;
            
        int left = 0, right = 0;
        if(root.left != null)
            left = helper(root.left, sum);
        if(root.right != null)
            right = helper(root.right, sum);
        return left+right;
    }
}