class Solution {
    int rows,cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islands++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid,boolean[][] visited,int r,int c){
        if(r<0 || r>=rows || c<0 || c>=cols) return;
        if(grid[r][c] == '0' || visited[r][c]) return;
        visited[r][c] = true;
        dfs(grid,visited,r+1,c);
        dfs(grid,visited,r-1,c);
        dfs(grid,visited,r,c+1);
        dfs(grid,visited,r,c-1);
    }
}