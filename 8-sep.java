// 1. Linked List Cycle   

class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(seen.contains(temp)){
                return true;
            }
            seen.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
