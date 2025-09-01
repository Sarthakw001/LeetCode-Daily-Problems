class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> ans(nums.size());
        int left = 0,right = nums.size()-1;
        int k = nums.size()-1;
        while(left <= right){
            if(nums[left] * nums[left] < nums[right] * nums[right]){
                ans[k] = nums[right] * nums[right];
                right--;
            }else{
                ans[k] = nums[left] * nums[left];
                left++;
            }
            k--;
        }
        return ans;
    }
};