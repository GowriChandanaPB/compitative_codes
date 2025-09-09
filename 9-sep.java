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
