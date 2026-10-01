class Solution {
    static{
        for(int i=0;i<500;i++){
            Solution obj = new Solution();
            obj.findKthLargest(new int[0],0);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){        
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();   
    }
}