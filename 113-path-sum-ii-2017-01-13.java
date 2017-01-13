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
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        // For leaf nodes, add it to solution when its value is equal to sum we are looking for
        if(root.left==null && root.right==null && root.val==sum){
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            res.add(list);
            return res;
        }
        
        // Get all paths from left subtree whose sum is (sum-root.val)
        for(List<Integer> list: pathSum(root.left, sum-root.val)){
            list.add(0,root.val);
            res.add(list);
        }
        // Get all paths from right subtree whose sum is (sum-root.val)
        for(List<Integer> list: pathSum(root.right, sum-root.val)){
            list.add(0,root.val);
            res.add(list);
        }
        return res;
        
    }
}