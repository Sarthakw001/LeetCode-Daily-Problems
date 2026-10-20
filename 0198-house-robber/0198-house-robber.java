class Solution {
    int robMoney(int[] nums,int start,int[] dp){
        if(start > nums.length-1) return 0;
        if(dp[start]!=-1) return dp[start];
        return dp[start] = Math.max(nums[start] + robMoney(nums,start+2,dp),robMoney(nums,start+1,dp));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robMoney(nums,0,dp);
    }
}