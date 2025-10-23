// 1. 01. Matrix 

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int max_val = m * n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = max_val;
                }
            }
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]] + 1) {
                    queue.offer(new int[]{r, c});
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }
        
        return mat;
    }
}


// 2. K Closest Points to Origin 

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) -
                                      (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}


// 3. Length of Longest Substring Without Repeating Characters 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max_len = 0;
        List<Character> list = new ArrayList<Character>();
        while(end < s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                end++;
                max_len = Math.max(max_len, list.size());
            } else {
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_len;
    }
}


// 4. 3 Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        res.addAll(s);
        return res;
    }
}


