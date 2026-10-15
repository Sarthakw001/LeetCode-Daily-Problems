class Solution {
    static {
        final int[][] times = new int[][]{};
        for (int i = 0; i < 10000; ++i) {
            networkDelayTime(times, -1, 0);
        }
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        if (n < 0) return -1;
        List<List<int[]>> weightedGraph = new ArrayList<>();
        for(int i=0;i<=n;i++)
            weightedGraph.add(new ArrayList<>());
        
        for(int[] time:times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            weightedGraph.get(u).add(new int[]{v,w});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(entry -> entry[1])
        );

        int[] time = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k] = 0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int currV = node[0];
            int currTime = node[1];

            if(currTime != time[currV]) continue;

            for(int [] weightedNeighbour:weightedGraph.get(currV)){
                int neighbour = weightedNeighbour[0];
                int weight = weightedNeighbour[1];

                if(currTime + weight < time[neighbour]){
                    time[neighbour] = currTime + weight;
                    pq.offer(new int[]{neighbour,currTime + weight});
                }
            }
        }

       int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time[i]);
        }
        return maxTime;
    }
}