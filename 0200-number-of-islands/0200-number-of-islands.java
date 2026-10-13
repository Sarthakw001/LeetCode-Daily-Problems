class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    islands++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return islands;
    }

    void dfs(int r, int c, char[][] grid, int[][] visited){
        if(r<0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0' || visited[r][c] == 1)
            return;
        visited[r][c] = 1;
        dfs(r+1,c,grid,visited);
        dfs(r-1,c,grid,visited);
        dfs(r,c+1,grid,visited);
        dfs(r,c-1,grid,visited);
    }
}