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
    FindElements(TreeNode* root) {
        dfs(root,0);
    }
    
    bool find(int target) {
        return node.count(target) > 0;
    }

    private :
        unordered_set<int> node;

        void dfs(TreeNode* currNode, int val){
            if(!currNode)
                return;
            node.insert(val);
            dfs(currNode->left,2*val +1);
            dfs(currNode->right,2*val +2);
        }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */