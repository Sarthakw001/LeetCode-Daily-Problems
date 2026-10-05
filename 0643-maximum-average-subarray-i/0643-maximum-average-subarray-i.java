class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}