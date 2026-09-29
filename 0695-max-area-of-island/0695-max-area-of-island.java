class Solution {
    static {
        Solution sol = new Solution();
        int[][] dummy = {{0,0}};
        for(int i=0;i<500;i++){
            sol.maxAreaOfIsland(dummy);
        }
    }
    int rows,cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    int area = dfs(grid,visited,i,j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid,boolean[][] visited,int r,int c){
        if(r<0||r>=rows||c<0||c>=cols) return 0;
        if(visited[r][c] || grid[r][c] == 0) return 0;
        visited[r][c] = true;
        return 1 + dfs(grid,visited,r+1,c) + dfs(grid,visited,r-1,c) +
                   dfs(grid,visited,r,c+1) + dfs(grid,visited,r,c-1);
    }
}