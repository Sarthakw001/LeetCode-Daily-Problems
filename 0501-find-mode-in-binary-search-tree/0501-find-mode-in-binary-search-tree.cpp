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
public:
    void util(TreeNode* root, unordered_map<int,int> &mp){
        if(!root) return;
        util(root->left,mp);
        mp[root->val]++;
        util(root->right,mp);
    }
    vector<int> findMode(TreeNode* root) {
        unordered_map<int,int> mp;
        util(root,mp);
        vector<int> ans;
        int freq = INT_MIN;
        for(auto it = mp.begin();it != mp.end();it++){
            if(it->second > freq)
                freq = it->second;
        }

        for(auto it = mp.begin();it != mp.end();it++){
            if(it->second == freq)
                ans.push_back(it->first);
        }
        return ans;
    }
};