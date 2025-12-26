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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBSTHelper(nums, 0, nums.length);
    }

    public TreeNode arrayToBSTHelper(int[] arr, int s, int e){
        if(s >= e) return null;
        int m = s + (e - s) / 2;

        TreeNode root = new TreeNode(arr[m]);

        root.left = arrayToBSTHelper(arr, s, m);
        
        root.right = arrayToBSTHelper(arr, m + 1, e);
        
        return root;
    }
}