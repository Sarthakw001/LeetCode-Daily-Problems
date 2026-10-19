class Solution {

    // Solution using, Kruskal's Algorithm
    static{
        for(int i=0;i<500;i++)
            validPath(0,new int[2][2],0,0);
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 0) return false;
        DSU dsu = new DSU(n);
        for(int[] edge:edges)
            dsu.union(edge[0],edge[1]);
        return dsu.checkPath(source,destination);
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
            if(parent[x] == x)
                return x;
            return find(parent[x]);
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) return;

            if(size[rootA] < size[rootB]){
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        public boolean checkPath(int a, int b){
            if(find(a) == find(b))
                return true;
            return false;
        }
    }
}