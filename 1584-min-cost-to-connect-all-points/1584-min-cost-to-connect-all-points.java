class Solution {
    static{
        for(int i=0;i<500;i++)
            minCostConnectPoints(new int[0][0]);
    }
    public static int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        if(n == 0) return 0; 
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                edges.add(new int[]{Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]), i, j});
            }
        }
        edges.sort((a,b) -> Integer.compare(a[0],b[0]));
        int ans = 0;
        DSU dsu = new DSU(n);
        for(int edge[] : edges){
            if(dsu.union(edge[1],edge[2])){
                ans += edge[0];
            }
        }
        return ans;
    }

    private static class DSU{
        private int[] parent;
        private int[] size;

        DSU(int n){
            this.parent = new int[n];
            this.size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int x){
            return parent[x] == x ? x : find(parent[x]);
        }
        
        public boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) return false;
            // if(size[rootA] < size[rootB]){
            //     int temp = rootA;
            //     rootA = rootB;
            //     rootB = temp;
            // }
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            return true;
        }
    }
}