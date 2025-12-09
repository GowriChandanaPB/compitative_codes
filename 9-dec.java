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
            if(slow == 1 || fast == 1) return true;
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