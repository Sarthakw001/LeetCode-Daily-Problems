class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return dfs(source, destination, graph, visited);
    }

    boolean dfs(int start, int end, List<List<Integer>> graph, boolean[] visited){
        visited[start] = true;
        if(start == end) return true;
        for(int neighbour: graph.get(start)){
            if(!visited[neighbour] && dfs(neighbour,end,graph,visited)){
                return true;
            }
        }
        return false;
    }
}