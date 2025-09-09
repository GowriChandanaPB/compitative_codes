// 1. Reverse Nodes in k-Group

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int grp = 0;
        while(temp != null && grp < k){
            temp = temp.next;
            grp++;
        }
        if(grp == k){
            temp = reverseKGroup(temp, k);
            while(grp -->0){
                ListNode cur = head.next;
                head.next = temp;
                temp = head;
                head = cur;
            }
            head = temp;
        }
        return head;
    }
}


// 2. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            } else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}


// 3. Best Time to Buy and Sell Stock (method 2)

public class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }
}


// 4. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            res = Math.max(res, i-l+1);
        }
        return res;
    }
}

