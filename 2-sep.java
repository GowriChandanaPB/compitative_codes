// 1. Power of 2

class Solution {
    public static boolean isPowerofTwo(int n) {
        // code here
        if(n<=0) return false;
        if(n==1) return true;
        while(n>1){
            if(n%2 == 0){
                n=n/2;
            } else {
                return false;
            }
        }
        return true;
    }
}


// 2. Stock Buy and Sell – Multiple Transaction Allowed