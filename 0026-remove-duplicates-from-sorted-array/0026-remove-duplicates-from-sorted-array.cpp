class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 1, j = 1;
        while(j<nums.size()){
            if(nums[j] != nums[i-1]){
                nums[i] = nums[j];
                i++;j++;
            }else{
                j++;
            }
        }
        return i;
    }
};