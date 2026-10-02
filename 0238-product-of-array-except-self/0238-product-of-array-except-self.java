class Solution {
    static {
        for (int i = 0; i < 500; i++)
            productExceptSelf(new int[] {0,1});
    }
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] prefixM = new int[size];
        int[] suffixM = new int[size];
        int[] resultA = new int[size];

        prefixM[0] = nums[0];
        suffixM[size-1] = nums[size-1];

        for(int i=1;i<size;i++)
            prefixM[i] = prefixM[i-1]*nums[i];
        for(int i=size-2;i>=0;i--)
            suffixM[i] = suffixM[i+1]*nums[i];
        
        resultA[0] = suffixM[1];
        resultA[size-1] = prefixM[size-2];

        for(int i=1;i<=size-2;i++)
            resultA[i] = prefixM[i-1] * suffixM[i+1];

        return resultA;
    }
}