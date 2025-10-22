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


// 3. Maximum Depth of Binary Tree 

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int res = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return res;
    }
}


// 4. Contains Duplicate 

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) return true; 
            set.add(i);
        }
        return false; 
    }
}