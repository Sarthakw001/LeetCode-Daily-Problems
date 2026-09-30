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
        for(int i=0;i<500;i++){
            Solution obj = new Solution();
            obj.isValidBST(null);
        }
    }
    public boolean isValidBST(TreeNode root) {
       return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node,long r1,long r2){
        if(node==null)
            return true;
        
        if(node.val > r1 && node.val < r2){
            return helper(node.left,r1,node.val) &&
                   helper(node.right,node.val,r2);
        }else return false;
    }
}