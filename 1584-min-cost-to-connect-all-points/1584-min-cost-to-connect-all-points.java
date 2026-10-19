class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> graph = new ArrayList<>();
        int n = points.length;

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                graph.get(i).add(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]),j});
                graph.get(j).add(new int[]{Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]),i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
           (a, b) -> Integer.compare(a[0], b[0])
        );
        
        boolean[] visited = new boolean[n];

        pq.offer(new int[]{0,0});
        int minManhattanDistance = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int manhattanDistance = current[0];
            int node = current[1];

            if(visited[node]) continue;

            visited[node] = true;
            minManhattanDistance += manhattanDistance;

            for(int[] edge : graph.get(node)){
                int neighbour = edge[1];
                int dist = edge[0];

                if(!visited[neighbour]){
                    pq.offer(new int[]{dist,neighbour});
                }
            }
        }
        return minManhattanDistance;
    }
}