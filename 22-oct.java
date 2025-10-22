// 1. Diameter of Binary Tree

class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;        
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        res = Math.max(res, l + r);
        return 1 + Math.max(l, r);
    }    
}


// 2. Middle of the Linked List

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}