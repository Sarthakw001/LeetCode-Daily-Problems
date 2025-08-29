class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int k = nums.size()-1,i = 0;
        while(i <= k){
            if(nums[i] == val){
                nums[i] = nums[k];
                k--;
            }
            else
                i++;
        }
        return i;   
    }
};