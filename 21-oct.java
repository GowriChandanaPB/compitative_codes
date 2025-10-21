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
