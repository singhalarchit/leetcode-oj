/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
  * Here, I have used List.add(0,item) to make my solution faster.
  */
  
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        // Make res a LinkedList rather than ArrayList
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
            
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                level.add(node.val);
            }
            
            // This is crucial here
            res.add(0,level);
        }
        
        return res;
        
    }
}