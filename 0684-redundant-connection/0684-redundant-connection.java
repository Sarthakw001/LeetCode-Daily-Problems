class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!dsu.union(u,v)){
                return new int[]{u,v};
            }
        }
        return new int[2];
    }

    private class DSU{
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
            if(parent[x] == x)
                return x;
            return find(parent[x]);
        }

        public boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) return false;

            if(size[rootA] < size[rootB]){
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];

            return true;
        }
    }
}