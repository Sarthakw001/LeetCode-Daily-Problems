/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int sum = 0;
public:
    void util(TreeNode* root, int low, int high){
        // Base Case
        if(!root) return;
        if(root->val >= low && root->val <= high) sum+= root->val;

        // Recursive Case
        if(low >= root->val) 
            util(root->right,low,high);
        else if(low < root->val && high > root->val){
             util(root->left,low,high);
             util(root->right,low,high);
        }else if(high <= root->val){
            util(root->left,low,high);
        }
    }
    int rangeSumBST(TreeNode* root, int low, int high) {
        util(root,low,high);
        return sum;
    }
};