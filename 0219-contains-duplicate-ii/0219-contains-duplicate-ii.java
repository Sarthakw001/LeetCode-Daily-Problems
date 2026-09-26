class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                int idx = mp.get(nums[i]);
                int absIdx = Math.abs(i-idx);
                if(absIdx <= k) return true;
                mp.put(nums[i],i);
            }else
                mp.put(nums[i],i);
        }
        return false;
    }
}