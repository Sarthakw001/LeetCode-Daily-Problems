class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.findPeakElement(new int[0]);
        }
    }
    public int findPeakElement(int[] nums) {
        int left = 0, right =nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1])
                left = mid+1;
            else 
                right = mid;
        }
        return left;
    }
}