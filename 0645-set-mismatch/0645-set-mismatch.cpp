class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        unordered_set<int>st;
    int r,m;
    for(int i=0;i<nums.size();i++){
        if(st.find(nums[i])!=st.end()) r = nums[i];
        st.insert(nums[i]);
    }
    for(int i=1;i<=nums.size();i++){
        if(st.find(i) == st.end()) m = i;
    }
    return {r,m};
    }
};