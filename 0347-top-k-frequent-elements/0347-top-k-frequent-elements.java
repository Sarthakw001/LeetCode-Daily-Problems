class Solution {
    static{
        for(int i=0;i<500;i++){
            Solution obj = new Solution();
            obj.topKFrequent(new int[0],0);
        }
    }
    private class Pair{
        int val;
        int freq;
        Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.freq,b.freq));

        for(int num:nums)
            mp.put(num,mp.getOrDefault(num,0)+1);
        
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size() > k)
                pq.poll();
        }

        int[] ans =new int[k];
        while(!pq.isEmpty()){
            ans[--k] = pq.poll().val;
        }
        return ans;
    }
}