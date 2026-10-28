class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(nums.length == 2)
            return nums;
        
        int i = 0, k = 0;

        int[]ans = new int[n*2];
        boolean flag = true;
        while(n<ans.length){
            if(flag){
                ans[k++] = nums[i++];
                flag = false;
            }else{
                ans[k++] = nums[n++];
                flag = true;
            }
        }
        return ans;
    }
}