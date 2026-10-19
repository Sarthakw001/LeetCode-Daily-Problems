class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int low = 0, high = nums.length - 1;
        int first = -1;

        // Step 1: Find the first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;  // Search further left
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        // Step 2: Collect all occurrences
        if (first != -1) {
            for (int i = first; i < nums.length && nums[i] == target; i++) {
                ans.add(i);
            }
        }

        return ans;
    }
}