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


// 5. Add Two Numbers

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode cur = temp;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return temp.next;
    }
}


// 6. Merge k Sorted Lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> node = new ArrayList<>();
        for (ListNode lst : lists) {
            while (lst != null) {
                node.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(node);

        ListNode res = new ListNode(0);
        ListNode temp = res;
        for (int i : node) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return res.next;
    }
}


// 7. LRU Cache

class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

