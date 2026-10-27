class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }

        dfs(0, 0, grid);

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }

    private boolean dfs(int i, int j, char[][] grid) {
        if (i >= grid.length || j >= grid[0].length)
            return false;

        grid[i][j] = '.';

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return true;

        if (dfs(i, j + 1, grid))
            return true;

        if (dfs(i + 1, j, grid))
            return true;

        grid[i][j] = '#';
        return false;
    }
}