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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = false;
        isSame = isSameTreeHelper(p, q);
        return isSame;
    }

    private boolean isSameTreeHelper(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p != null && q == null) return false;
    if(p == null && q != null) return false;

    if(p.val != q.val) return false;
    boolean isLeft = isSameTreeHelper(p.left, q.left);
    boolean isRight = isSameTreeHelper(p.right, q.right);
    return isLeft && isRight;
  }
}