// 1. Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotate = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotate[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}



// 2. Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] step = {matrix[0].length, matrix.length - 1};

        int r = 0, c = -1, d = 0;
        while (step[d % 2] > 0) {
            for (int i = 0; i < step[d % 2]; i++) {
                r += dir[d][0];
                c += dir[d][1];
                res.add(matrix[r][c]);
            }
            step[d % 2]--;
            d = (d + 1) % 4;
        }
        return res;
    }
}