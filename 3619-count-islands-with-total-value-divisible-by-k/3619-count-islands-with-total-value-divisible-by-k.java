class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(i, j, grid);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    long dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }

        long value = grid[i][j];
        grid[i][j] = 0;

        value += dfs(i + 1, j, grid);
        value += dfs(i - 1, j, grid);
        value += dfs(i, j + 1, grid);
        value += dfs(i, j - 1, grid);

        return value;
    }
}