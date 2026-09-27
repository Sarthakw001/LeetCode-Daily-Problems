class Solution {
    public int maxArea(int[] height) {
        int maxWater = -1, left = 0, right = height.length - 1;
        while(left < right){
            int water = (right-left) * Math.min(height[left],height[right]);
            maxWater = Math.max(maxWater,water);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}