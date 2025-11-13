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


// 2. Rotting Oranges

class Solution {   
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;       
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }       
        return minutes - 2;
    }
    
    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes)
          ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}