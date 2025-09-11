// 1. Diameter of Binary Tree

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    public int dfs(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }
}


// 2. Balanced Binary Tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        if(left == -1) return -1;
        int right = dfs(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}


// 3. Same Tree

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}


// 4. Subtree of Another Tree

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}


// 5. Lowest Common Ancestor in Binary Search Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}


// 6. Binary Tree Level Order Traversal

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if (node == null) return;
        if(res.size() == depth) res.add(new ArrayList<>());
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}


// 7. Binary Tree Right Side View

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if(node == null) return;
        if(res.size() == depth) res.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}


// 8. Count Good Nodes in Binary Tree

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    public void dfs(TreeNode node, int maxVal){
        if(node == null) return;
        if(node.val >= maxVal){
            count++;
            maxVal = node.val;
        }
        dfs(node.left, maxVal);
        dfs(node.right, maxVal);
    }
}

