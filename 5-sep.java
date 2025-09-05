// 1. Search a 2D Matrix

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;

        int l = 0, r = row * col - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int rw = m / col, cl = m % col;
            if (target > matrix[rw][cl]) {
                l = m + 1;
            } else if (target < matrix[rw][cl]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}


// 2. Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r ;
        while(l <= r){
            int m = (l + r) / 2;
            long total = 0;
            for(int i : piles){
                total += Math.ceil((double) i / m);
            }
            if(total <= h){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}