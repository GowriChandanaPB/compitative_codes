// 1. Lowest Common Ancestor of a Binary Search Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            } else if(p.val < root.val && q.val < root.val){
                root = root.left;
            } else{
                return root;
            }
        }
        return null;
    }
}


// 2. Binary Search Tree | Set 1 (Search and Insertion)

class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // Your code here
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        if(x < root.data){
            return search(root.left, x);
        }
        return search(root.right, x);
    }
}


// 3. Minimum element in BST 

class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        if(root == null){
            return root.data;
        }
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
}