class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int stone : stones)
            pq.offer(stone);
        
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            if(x!=y) pq.offer(y-x);
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}