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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;
        if(root.left==null && root.right==null){
            res.add(root.val+"");
            return res;
        }
        for(String path: binaryTreePaths(root.left)){
            res.add(root.val+"->"+path);
        }
        for(String path: binaryTreePaths(root.right)){
            res.add(root.val+"->"+path);
        }
        return res;
    }
}