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
  * Here, I have used a stack along with a queue to get the result in reverse order. I know this is not the best way to do it.
  * I can simply use List.add(0,item) istead.
  */
  
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
            
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                stack.push(node);
                // Check right first, then left
                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
            
            // Add null TreeNode to stack, every time a level is completed.
            stack.push(null);
        }
        
        List<Integer> level = new ArrayList<>();
        stack.pop();
        
        while(!stack.isEmpty()){
            
            // Level completed, add level to res
            if(stack.peek()==null){
                res.add(level);
                level = new ArrayList<>();
                stack.pop();
            }
            
            level.add(stack.pop().val);
        }
        
        // add root to res
        res.add(level);
        
        return res;
        
    }
}