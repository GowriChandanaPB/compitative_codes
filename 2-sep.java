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


// 4. Count pairs with given sum

class Solution {

    int countPairs(int arr[], int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
         int count=0;
         for(int i:arr){
             count += map.getOrDefault(target-i,0);
             map.put(i,map.getOrDefault(i,0)+1);
         }
         return count;
    }
}

// 5. Longest Consecutive Sequence

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, p = nums[0], q = 0, i = 0;

        while (i < nums.length) {
            if (p != nums[i]) {
                p = nums[i];
                q = 0;
            }
            while (i < nums.length && nums[i] == q) {
                i++;
            }
            q++;
            p++;
            res = Math.max(res, q);
        }
        return res;
    }
}


// 6. Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
        String low_s = s.toLowerCase();
        String fin = low_s.replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = fin.length() - 1;
        while (left < right){
            if(fin.charAt(left)!=fin.charAt(right)){
                return false;
            } 
            left++;
            right--;
        }
        return true;
    }
}