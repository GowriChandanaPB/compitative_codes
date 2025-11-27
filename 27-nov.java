// 1, Find the number of islands

class Solution {
      public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] ==  'L'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
         if(i<0||j<0||i>=grid.length ||j>=grid[0].length || grid[i][j] == 'W')
            return;
        grid[i][j] = 'W';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j-1);
        dfs(grid,i-1,j+1);
        dfs(grid,i+1,j-1);
        dfs(grid,i+1,j+1);
    }
}