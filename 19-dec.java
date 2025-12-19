// 1. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int og = x;
        int rev = 0;
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return og == rev;
    }
}


// 2. ip address 

public class Solution {
    public String validIPAddress(String IP) {
        if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
        return "Neither";
    }
}