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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        depth(root);
        return diameter;
    }

    int depth(TreeNode node){
        if(node == null) return 0;
        int leftDept = depth(node.left);
        int righDept = depth(node.right);
        diameter = Math.max(diameter,leftDept+righDept);
        return 1 + Math.max(leftDept, righDept);
    }
}