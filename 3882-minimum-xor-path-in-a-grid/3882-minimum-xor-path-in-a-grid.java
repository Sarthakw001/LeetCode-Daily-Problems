import java.util.*;

class Solution {
    private int minXor = Integer.MAX_VALUE;
    private Set<Integer> visited;

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

        int key = (i * n + j) * 1024 + currXor;

        if (!visited.add(key)) {
            return;
        }

        findPath(i + 1, j, grid, currXor);
        findPath(i, j + 1, grid, currXor);
    }

    public int minCost(int[][] grid) {
        minXor = Integer.MAX_VALUE;
        visited = new HashSet<>();

        findPath(0, 0, grid, 0);

        return minXor;
    }
}