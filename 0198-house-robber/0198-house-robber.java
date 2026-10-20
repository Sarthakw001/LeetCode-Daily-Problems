class Solution {

    int robMoney(int[] nums,int start,int[] dp){
        if(start > nums.length-1) 
            return 0;
        if(dp[start]!=-1) return dp[start];
        int rob1 = nums[start] + robMoney(nums,start+2,dp);
        int rob2 = robMoney(nums,start+1,dp);
        int currMax = Math.max(rob1,rob2);
        dp[start] = currMax;
        return currMax;
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return robMoney(nums,0,dp);
    }
}