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


// 2. Reorder List

class Solution {
    public void reorderList(ListNode head) {
        head = reorder(head, head.next);
    }
    public ListNode reorder(ListNode root, ListNode cur){
        if(cur == null){
            return root;
        }
        root = reorder(root, cur.next);
        if(root == null){
            return null;
        }
        ListNode temp = null;
        if(root == cur || root.next == cur){
            cur.next = null;
        } else {
            temp = root.next;
            root.next = cur;
            cur.next = temp;
        }
        return temp;
    }
}
