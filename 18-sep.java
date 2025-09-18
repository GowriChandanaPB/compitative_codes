//1. N-Queens

class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> pos = new HashSet<>();
    Set<Integer> neg = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || pos.contains(r + c)
                || neg.contains(r - c)) {
                continue;
            }
            col.add(c);
            pos.add(r + c);
            neg.add(r - c);
            board[r][c] = 'Q';
            backtrack(r + 1, n, board);
            col.remove(c);
            pos.remove(r + c);
            neg.remove(r - c);
            board[r][c] = '.';
        }
    }
}


// 2. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }

        return res;
    }
}


// 3. Permutations

public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            res.add(perm);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            backtrack(nums, idx + 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}