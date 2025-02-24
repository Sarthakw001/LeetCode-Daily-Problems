/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    unordered_map<int, int> postOrderMp;
    TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) {
        for (int i = 0; i < postorder.size(); i++)
            postOrderMp[postorder[i]] = i;

        return buildTree(preorder, 0, preorder.size() - 1, postorder, 0, postorder.size() - 1);
    }
private:
    TreeNode* buildTree(vector<int>& preorder,int preStart, int preEnd, vector<int>& postorder, int postStart, int postEnd){
        if(preStart > preEnd)
            return nullptr;
        TreeNode* root = new TreeNode(preorder[preStart]);

        if(preStart == preEnd)
            return root;
        
        int leftRootIndex = postOrderMp[preorder[preStart+1]];

        int leftSubtreeLength = leftRootIndex - postStart + 1;

        root->left = buildTree(preorder, preStart + 1, preStart + leftSubtreeLength,
                               postorder, postStart, leftRootIndex);

        root->right = buildTree(preorder, preStart + leftSubtreeLength + 1, preEnd,
                                postorder, leftRootIndex + 1, postEnd - 1);

        return root;
    }
};