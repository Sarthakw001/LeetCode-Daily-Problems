class Solution {
    Set<Integer> terminalNodes = new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] safeNodes = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(graph[i].length == 0){
                terminalNodes.add(i);
                safeNodes[i] = 1;
            }
        }

        for(int i=0;i<graph.length;i++){
            int[] visited = new int[graph.length];
            dfs(i,graph,safeNodes,visited);
        }
        List<Integer> safeNode = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(safeNodes[i] == 1)
                safeNode.add(i);
        }
        return safeNode;
    }

    boolean dfs(int node, int[][] graph, int[] safeNodes, int[] visited){
        if(visited[node] == 1) return false;
        if(terminalNodes.contains(node)) return true;
        if(visited[node] == 2) return true;

        visited[node] = 1;
        for(int i=0;i<graph[node].length;i++){
            boolean validPath = dfs(graph[node][i],graph,safeNodes,visited);
            if(validPath){
                safeNodes[node] = 1;
            }else{
                safeNodes[node] = 0;
                return false;
            }
        }
        visited[node] = 2;
        return true;  
    }
}