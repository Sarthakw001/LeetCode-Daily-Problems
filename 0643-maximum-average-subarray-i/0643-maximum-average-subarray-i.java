class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) windowSum += nums[i];
        
        double maxWindowSumAvg = (double) windowSum / k;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];

            double currWindowSumAvg = (double) windowSum / k;
            maxWindowSumAvg = Math.max(maxWindowSumAvg, currWindowSumAvg);
        }

        return maxWindowSumAvg;
    }
}