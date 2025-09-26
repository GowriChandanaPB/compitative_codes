// 1. Reverse Integer

class Solution {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}


// 2. String to Integer (atoi)

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


// 3. Integer to Roman