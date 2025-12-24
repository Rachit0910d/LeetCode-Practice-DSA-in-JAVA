/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();
    
        List<Double> ans = new ArrayList<>();
    
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
    
        while(!pendingNodes.isEmpty()){
            int levelSize = pendingNodes.size();
            double avg = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = pendingNodes.remove();
                avg += node.val;
                if(node.left != null){
                pendingNodes.add(node.left);
                }
                if(node.right != null){
                pendingNodes.add(node.right);
                }
            }
            avg /= levelSize;
            ans.add(avg);
        }
        return ans;
        }
}