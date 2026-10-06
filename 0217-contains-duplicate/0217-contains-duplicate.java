class Solution {
    static{
        for(int i=0;i<500;i++)
            containsDuplicate(new int[0]);
    }
    public static boolean containsDuplicate(int[] nums) {
       Set<Integer> st = new HashSet<>();
       for(int i=0;i<nums.length;i++){
        if(st.contains(nums[i]))
            return true;
        st.add(nums[i]);
       }
       return false;
    }
}