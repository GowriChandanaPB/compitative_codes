// 1. linked list cycle

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}


// 2. Linked List Cycle II

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}



// 3. Middle of the Linked List

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null){
            if(fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


// 4. Happy Number

class Solution {
    public boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));
        while(slow != fast){
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow == 1;
    }
    public int square(int n){
        int res = 0;
        while(n > 0){
            int x = n%10;
            res += x*x;
            n = n/10;
        }
        return res;
    }
}



// 5.  Palindrome Linked List

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        int left = 0, right = arr.size()-1;
        while(left < right){
            if(!arr.get(left).equals(arr.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}



// 6. Maximum Sum of Distinct Subarrays With Length K

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        long cursum = 0, maxsum = 0;
        for(int right = 0; right<nums.length; right++){
            while(set.contains(nums[right]) || set.size() == k){
                set.remove(nums[left]);
                cursum -= nums[left];
                left++;
            }
            cursum += nums[right];
            set.add(nums[right]);
            if(set.size() == k){
                maxsum = Math.max(cursum, maxsum);
            }
        }
        return maxsum;
    }
}



// 7. ongest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int left =0;
        for(int right=0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}