// 1. Maximum Depth of Binary Tree

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        return res;
    }
}


//2.Reverse Level Order Traversal

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        int level = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            ans.add(temp.data);
            if(temp.right != null){
                q.add(temp.right);
            }
            if (temp.left != null){
                q.add(temp.left);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}


// 3. Subtree of Another Tree

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String subStr = serialize(subRoot);
        String rootStr = serialize(root);
        return rootStr.contains(subStr);
    }
     private String serialize(TreeNode node) {
        if (node == null) {
            return ",#";
        }
        return "," + node.val + serialize(node.left) + serialize(node.right);
    }
}


// 4.Invert Binary Tree

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;

    }
}