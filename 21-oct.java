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