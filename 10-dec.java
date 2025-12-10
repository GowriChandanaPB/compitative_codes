// 1. remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode f = temp, s = temp; 
        for(int i=0; i<n; i++) s = s.next;
        while(s.next != null){
            f = f.next;
            s = s.next;
        }
        f.next = f.next.next;
        return temp.next;
    }
}

