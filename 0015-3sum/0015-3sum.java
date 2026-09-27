class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> st = new HashSet<>();
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int target = nums[i];
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[left] + nums[right] + target;
                if(sum == 0){
                    st.add(List.of(nums[left],nums[right],nums[i]));
                    left++;right--;
                }else if(sum < 0)left++;
                else right--;
            }
        }
        ls.addAll(st);
        return ls;
    }
}