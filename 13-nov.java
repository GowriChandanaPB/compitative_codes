// 1. Number of Islands

class Solution {
    public void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != '1') return;
        grid[r][c] = '0'; 

        dfs(grid , r + 1 , c);
        dfs(grid , r - 1 , c);
        dfs(grid , r , c + 1);
        dfs(grid , r , c - 1);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid , i , j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}