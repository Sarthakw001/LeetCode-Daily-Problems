class Solution {
    int rows,cols;
    int[][] directions = {
        {1, 0},    // down
        {-1, 0},   // up
        {0, 1},    // right
        {0, -1}    // left
    };
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        rows = grid.length;
        cols = grid[0].length;
        int fresh=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;
        while(!q.isEmpty()&&fresh>0){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir:directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr<0||nr>=rows||nc<0||nc>=cols||grid[nr][nc]==0||grid[nr][nc]==2)
                        continue;
                    
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
            time++;
        }
        return fresh==0 ? time: -1;
    }
}