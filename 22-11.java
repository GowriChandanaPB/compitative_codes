// 1. String to Integer (atoi)

class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        int sign = 1, i = 0;
        long res = 0;
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') { i++; }
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break; 
            res = res * 10 + (ch - '0'); 
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE; 
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }
}


// 2. Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row_start = 0;
        int row_end = matrix.length-1;
        int col_start = 0;
        int col_end = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0) return res;
        while(row_start <= row_end && col_start <= col_end){
            for(int i=col_start; i<= col_end; i++) res.add(matrix[row_start][i]);
            row_start++;

            for(int i=row_start; i<= row_end; i++) res.add(matrix[i][col_end]);
            col_end--;

            if(row_start <= row_end){
                for(int i=col_end; i>=col_start; i--) res.add(matrix[row_end][i]);
            }
            row_end--;

            if(col_start <= col_end){
                for(int i=row_end; i>=row_start; i--) res.add(matrix[i][col_start]);
            }
            col_start++;
        }
        return res;
    }
}


// 3. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sset = new ArrayList<>();
        createSubset(nums, 0, res, sset); return res;        
    }

    private void createSubset(int[] nums, int idx, List<List<Integer>> res, List<Integer> sset) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(sset)); return;
        }
        sset.add(nums[idx]);
        createSubset(nums, idx + 1, res, sset);
        sset.remove(sset.size() - 1);
        createSubset(nums, idx + 1, res, sset);
    }    
}


// 4. Binary Tree Right Side View

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}


// 5. Longest Palindromic Substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String result = s.substring(0, 1); 
        for (int i = 1; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                String palin = s.substring(l, r + 1);
                if (palin.length() > result.length()) result = palin;
                l--; r++;
            }
            l = i - 1; r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                String palin = s.substring(l, r + 1);
                if (palin.length() > result.length()) result = palin;
                l--; r++;
            }
        }
        return result;
    }
}