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

class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int profit = 0;
        for (int i=1; i<prices.length; i++) 
        {
            if (prices[i-1]<prices[i]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}


// 3. Left View of Binary Tree

class Solution {
   ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer>list=new ArrayList<>();
        leftV(root,list,0);
        return list;
        
    }
    
    public static void leftV(Node root,ArrayList<Integer> list,int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        leftV(root.left,list,level+1);
        leftV(root.right,list,level+1);
        
    }
}