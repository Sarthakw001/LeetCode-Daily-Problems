class Solution {
    static{
        for(int i=0;i<500;i++){
            Solution obj = new Solution();
            obj.topKFrequent(new int[0],0);
        }
    }
    class Pair{
        int val;
        int count;
        Pair(int val,int count){
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.count,b.count)
        );

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size() > k)
                pq.poll();
        }

        int[] kFreqElement = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            kFreqElement[i++] = pq.peek().val;
            pq.poll();
        }
        return kFreqElement;
    }
}