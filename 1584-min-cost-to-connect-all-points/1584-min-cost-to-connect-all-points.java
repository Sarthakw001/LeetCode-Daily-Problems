class Solution {
    private int[] parent;
    private int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                edges.add(new int[]{Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]), i, j});
            }
        }

        edges.sort((a,b) -> Integer.compare(a[0],b[0]));
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;

        int ans = 0, used = 0;

        for(int[] e:edges){
            if(used == n-1) break;
            int a = find(e[1]);
            int b = find(e[2]);

            if(a!=b){
                parent[Math.max(a,b)] = Math.min(a,b);
                ans+=e[0];
                used++;
            }
        }
        return ans;
    }
}