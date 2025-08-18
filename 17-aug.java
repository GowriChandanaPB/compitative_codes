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


// 4. Predecessor and Successor

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> result = new ArrayList<>();
        Node predecessor = null;
        Node successor = null;
        while (root != null) {
            if (root.data == key) {
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }
                break;
            } else if (root.data < key) {
                predecessor = root;
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        result.add(predecessor);
        result.add(successor);
        return result;
    
    }
}


// 5. Check whether BST contains Dead End

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
        return end(root , 0 , Integer.MAX_VALUE);
    }
    public static boolean end(Node root , int min , int max){
        if(root == null){
            return false;
        }
        if(min+1 == root.data && max-1 == root.data){
            return true;
        }
        return end(root.left , min , root.data) || end(root.right , root.data ,max);
    }
}


// 6. Binary Tree to BST

class Solution
{
    ArrayList<Integer> list = new ArrayList<>();
    void inorder(Node root) {
        if(root==null) return;
          inorder(root.left);
          list.add(root.data);
          inorder(root.right);
    }
    void intact(Node root) {
        if(root==null) return;
          intact(root.left);
          root.data=list.remove(0);
          intact(root.right);
    }
    Node binaryTreeToBST(Node root) {
       inorder(root);
       Collections.sort(list);
       intact(root);
       return root;
    }
}


// 7. Kth largest element in BST 

class Solution {
    int count = 0, ans = -1;
    public int kthLargest(Node root, int k) {
        if (root == null){
            return -1;
        }
        kthLargest(root.right, k);  
        count++;
        if (count == k) ans = root.data;
        kthLargest(root.left, k);    
        return ans;
    }
}