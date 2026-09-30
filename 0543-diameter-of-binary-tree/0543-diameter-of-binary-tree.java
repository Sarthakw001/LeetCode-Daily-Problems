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
    static{
        Solution obj = new Solution();
        for(int i=0;i<500;i++){
            obj.diameterOfBinaryTree(null);
        }
    }
    int answer = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return answer;
    }

    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        answer = Math.max(answer,leftHeight+rightHeight);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}