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

// 6. Unique Paths

class Solution {
    public int uniquePaths(int m, int n) {
        int[] aRow = new int[n];
        Arrays.fill(aRow, 1);
        for (int row = 1; row < m; row++) {
            int[] cRow = new int[n];
            Arrays.fill(cRow, 1);
            for (int col = 1; col < n; col++) cRow[col] = cRow[col - 1] + aRow[col];
            aRow = cRow;
        }
        return aRow[n - 1];        
    }
}


// 7. Container With Most Water

class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) l++;
            else r--
        }
        return res;
    }
}


// 8. Construct Binary Tree from Preorder and Inorder Traversal

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rooti = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                rooti = i;
                break;
            }
        }
        int [] leftpre = Arrays.copyOfRange(preorder, 1, 1 + rooti);
        int [] rightpre = Arrays.copyOfRange(preorder, 1 + rooti, preorder.length);
        int [] leftin = Arrays.copyOfRange(inorder, 0, rooti);
        int [] rightin = Arrays.copyOfRange(inorder, 1 + rooti, inorder.length);
        root.left = buildTree(leftpre, leftin);
        root.right = buildTree(rightpre, rightin);
        return root;
    }
}


// 9. Letter Combinations of a Phone Number

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), res, map);
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> map) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        
        String letters = map.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, map);
            comb.deleteCharAt(comb.length() - 1);
        }
    }    
}