// 1. Pow(x, n)

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        double res = 1;
        for(int i=0; i<Math.abs(n); i++){
            res *= x;
        }
        return n >= 0 ? res : 1 / res;
    }
}


// 2. Multiply Strings

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + pos[i + j + 1];

                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


// 3. Detect Squares

class CountSquares {
    Map<List<Integer>, Integer> count;
    List<List<Integer>> pts;
    public CountSquares() {
        count = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        count.put(p, count.getOrDefault(p, 0) + 1);
        pts.add(p);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (List<Integer> pt : pts) {
            int x = pt.get(0), y = pt.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            res += count.getOrDefault(Arrays.asList(x, py), 0) *
                   count.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}


// 4. Plus One

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}