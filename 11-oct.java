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


// 3. Set Matrix Zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[] rowZero = new boolean[row];
        boolean[] colZero = new boolean[col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 0) {
                    rowZero[r] = true;
                    colZero[c] = true;
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (rowZero[r] || colZero[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}


// 4. Happy Number

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {
            visit.add(n);
            n = squares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int squares(int n) {
        int res = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            res += digit;
            n /= 10;
        }
        return res;
    }
}