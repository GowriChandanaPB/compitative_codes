// 1. Linked list cycle

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}


// 2. Implement Queue using Stacks

class MyQueue {
    private Stack<Integer> ip;
    private Stack<Integer> op;

    public MyQueue() {
        ip = new Stack<>();
        op = new Stack<>();    
    }
    
    public void push(int x) {
        ip.push(x);
    }
    
    public int pop() {
        peek();
        return op.pop();
    }
    
    public int peek() {
        if(op.isEmpty()){
            while(!ip.isEmpty()){
                op.push(ip.pop());
            }
        }
        return op.peek();
    }
    
    public boolean empty() {
        return ip.isEmpty() && op.isEmpty();
    }
}


// 3. First Bad Version 

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}


// 4. Ransom Note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap <Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) <= 0) return false;
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}


// 5. Climbing Stairs

class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        int prev = 1;
        int curr = 1;
        for(int i=2; i<=n; i++){
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}


// 6. Longest Palindrome 

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> map = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (map.contains(c)) {
                map.remove(c);
                length += 2;
            } else map.add(c);
        }
        if (!map.isEmpty()) length += 1;
        return length;
    }
}


// 7. Reverse Linked List

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }

        return node;        
    }
}


// 8. Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int cand=0;
        for(int i=0; i<nums.length; i++){
            if(count==0) cand=nums[i];
            if(cand==nums[i]) count++;
            else count--;
        }
        return cand;
    }
}


// 9. binary add

class Solution 
{
  public String addBinary(String a, String b) 
  {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry == 1) 
    {
      if(i >= 0) carry += a.charAt(i--) - '0';
      if(j >= 0) carry += b.charAt(j--) - '0';
      sb.append(carry % 2);
      carry /= 2;
    }
    return sb.reverse().toString();
  }
}