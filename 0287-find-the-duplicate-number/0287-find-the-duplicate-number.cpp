class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(1){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = nums[0];
        while(1){
            if(slow == fast) return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return 0;
    }
};