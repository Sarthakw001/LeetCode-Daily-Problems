import java.util.Arrays;

class Solution {
    private int[][][] dp;
    private int minXor = Integer.MAX_VALUE;

    private void findPath(int i, int j, int[][] grid, int currXor) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return;
        }

        currXor ^= grid[i][j];

        if (i == m - 1 && j == n - 1) {
            minXor = Math.min(minXor, currXor);
            return;
        }

        if (dp[i][j][currXor] != -1) {
            return;
        }

        dp[i][j][currXor] = 1;

        findPath(i + 1, j, grid, currXor);
        findPath(i, j + 1, grid, currXor);
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][1024];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        minXor = Integer.MAX_VALUE;
        findPath(0, 0, grid, 0);

        return minXor;
    }
}