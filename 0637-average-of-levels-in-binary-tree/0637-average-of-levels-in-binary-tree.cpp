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
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode*> q;
        vector<double> v;
        if(!root)
            return v;
        q.push(root);
        q.push(nullptr);
        while(q.front()){
            double sum = 0.0;
            int count = 0;
            while(true){
                TreeNode* temp = q.front();
                q.pop();
                if(temp == nullptr){
                    q.push(nullptr);
                    break;
                }
                sum+= (double) temp->val;
                count++;
                if(temp->left) q.push(temp->left);
                if(temp->right) q.push(temp->right);
            }
            double avg = sum / (double)(count);
            v.push_back(avg);
        }
        return v;
    }
};