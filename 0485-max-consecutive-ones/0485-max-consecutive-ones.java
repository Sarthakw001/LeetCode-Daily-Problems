class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = -1;
        for(int i:nums){
            if(i == 1)
                count++;
            else{
                maxCount = Math.max(count,maxCount);
                count = 0;
            }
        }
        maxCount = Math.max(count,maxCount);
        return maxCount;
    }
}