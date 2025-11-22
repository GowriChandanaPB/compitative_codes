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