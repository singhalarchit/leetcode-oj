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
  * The trick is to use a flag "step". Whenever the flag is set, insert into LinkedList in reverse order.
  */
  
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
            
        Queue<TreeNode> q = new LinkedList<>();
        // Crucial here
        boolean step = false;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            // Make level a LinkedList rather than ArrayList
            List<Integer> level = new LinkedList<>();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(step)
                    level.add(0,node.val);
                else
                    level.add(node.val);
            }
            
            res.add(level);
            // Reverse step
            step = step? false:true;
        }
        
        return res;
    }
}