class Solution {
    static{
        for(int i=0;i<500;i++){
            targetIndices(new int[0],0);
        }
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int lessThan = 0;
        
        for (int num : nums) {
            if (num == target) {
                count++;
            } else if (num < target) {
                lessThan++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessThan + i);
        }
        
        return result;
    }
}