class Solution {
public:
    void solve(vector<int>&nums,int start,int end){
        while(start<end){
            swap(nums[start],nums[end]);
            start++,end--;
        }
    }
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        int n = nums.size();
        solve(nums,0,n-k-1);
        solve(nums,n-k,n-1);
        solve(nums,0,n-1);
    }
};