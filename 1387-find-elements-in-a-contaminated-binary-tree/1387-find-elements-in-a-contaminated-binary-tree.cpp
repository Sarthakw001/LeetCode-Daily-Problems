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
class FindElements {
public:
    TreeNode* newRoot = new TreeNode();

    void recoverBtree(TreeNode* root,TreeNode* newRoot){
        if(!root->left && !root->right){
            return;
        }
        if(root->left != nullptr){
            newRoot->left = new TreeNode(2*newRoot->val + 1);
            recoverBtree(root->left, newRoot->left);
        }
        if(root->right != nullptr){
            newRoot->right = new TreeNode(2*newRoot->val + 2);
            recoverBtree(root->right,newRoot->right);
        }
    }

    FindElements(TreeNode* root) {
        recoverBtree(root,newRoot);
    }
    
    bool search(TreeNode* root,int target){
        if(!root){
            return false;
        }
        if(root->val == target){
            return true;
        }
        bool left = search(root->left,target);
        bool right = search(root->right, target);

        return left || right;
    }

    bool find(int target) {
        return search(newRoot, target);
    }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */