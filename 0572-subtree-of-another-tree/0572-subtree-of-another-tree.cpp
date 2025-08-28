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
    bool ans = false;
public:
    bool sameTree(TreeNode* p, TreeNode* q){
       // Base Case
        if(!p && !q)
            return true;
        if((!p && q) || (p && !q))
            return false;
        if(p->val != q->val)
            return false;

        // Recursive Case
        return sameTree(p->left,q->left) && sameTree(p->right,q->right);
    }
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        // Base Case
        if(!root)
            return false;
        if(sameTree(root,subRoot))  return true;
        // Recursive Case
        bool left = isSubtree(root->left,subRoot);
        bool right = isSubtree(root->right,subRoot);

        return ans || left || right;
    }
};