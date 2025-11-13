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


// 3. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) h = m - 1;
                else l = m + 1;    
            } else {
                if (nums[m] < target && target <= nums[h]) l = m + 1;
                else h = m - 1;
                }
            }
        return -1;
    }
}


// 4. Combination Sum

class Solution {
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> answer, List<Integer> ds)
    {
        if(index == arr.length)
        {
            if(target == 0) answer.add(new ArrayList<>(ds));
            return;
        }
        if(arr[index] <= target)
        {
            ds.add(arr[index]);
            findCombinations(index, arr, target-arr[index], answer, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index + 1, arr, target, answer, ds); 
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        findCombinations(0, candidates, target, answer, new ArrayList<>());
        return answer;
    }
}


// 5. Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[0]);
            res.add(single);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] remainNums = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remainNums[index] = nums[j];
                    index++;
                }
            }            
            List<List<Integer>> perms = permute(remainNums);
            for (List<Integer> p : perms) {
                p.add(n);
            }   
            res.addAll(perms);
        }
        return res;        
    }
}


// 6. Merge Intervals

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int[] i : intervals) {
            int p = i[0];
            int q = i[1];
            int lastEnd = res.get(res.size() - 1)[1];
            if (p <= lastEnd) res.get(res.size() - 1)[1] = Math.max(lastEnd, q);
            else res.add(new int[]{p, q});
        }
        return res.toArray(new int[res.size()][]);
    }
}