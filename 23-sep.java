// 1. Combination Sum

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}


// 2. Combination Sum II

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i + 1);
        cur.remove(cur.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        backtrack(nums, target, cur, i + 1);
    }
}


// 3. Subsets II

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList();
        backtrack(nums, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> cur, int i) {
        res.add(new ArrayList(cur));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            cur.add(nums[j]);
            backtrack(nums, cur, j + 1);
            cur.remove(cur.size() - 1);
        }
    }
}


// 4. Word Search

class Solution {
    private int row, col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= row || c >= col ||
            board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }
}