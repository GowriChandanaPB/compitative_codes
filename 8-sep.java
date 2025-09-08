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


// 3. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode p = temp;
        ListNode q = head;
        while(n>0){
            q = q.next;
            n--;
        }
        while(q != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return temp.next;
    }
}


// 4. Copy List with Random Pointer

class Solution {
     HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
       
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node temp = new Node(head.val);
        map.put(head, temp);
        temp.next = copyRandomList(head.next);
        temp.random = map.get(head.random);
        return temp;
    }
}