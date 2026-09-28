class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.search(new int[0],0);
        }
    }
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]) return mid;
            if(nums[left] <= nums[mid]){
                ans = binarySearch(nums,left,mid-1,target);
                if(ans == -1)
                    left = mid + 1;
                else
                    return ans;
            }
            else if(nums[mid] <= nums[right]){
                ans = binarySearch(nums,mid+1,right,target);
                if(ans == -1)
                    right = mid -1;
                else
                    return ans;
            }
        }
        return ans;
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(left<=right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]) return mid;
            else if(target < nums[mid]) return binarySearch(nums,left,mid-1,target);
            else return binarySearch(nums,mid+1,right,target);
        }
        return -1;
    }

}