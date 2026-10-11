class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],i);
        
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                int idx = mp.get(target-nums[i]);
                if(idx!=i){
                    return new int[]{i,idx};
                }
            }
        }
        return new int[]{-1,-1};
    }
}