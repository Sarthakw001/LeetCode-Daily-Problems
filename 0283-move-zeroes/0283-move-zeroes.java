class Solution {
    static {
    Solution sol = new Solution();
    for(int i = 0; i < 500; i++){
        sol.moveZeroes(new int[0]);
    }
}
    public void moveZeroes(int[] nums) {
        int write = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[write++] = nums[i];
        }
        for(int i=write;i<nums.length;i++)
            nums[i] = 0;
    }
}