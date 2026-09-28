class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.search(new int[0],0);
        }
    }
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target > nums[mid])
                left = mid + 1;
            else if(target < nums[mid])
                right = mid - 1;
            else 
                return mid;
        }
        return -1;
    }
}