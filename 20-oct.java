// 1. flood fill

class Solution {
    public void solve(int[][] image, int sr, int sc, int color, int orcolor){
        if(sr < 0 || sc<0 || sr >= image.length || sc >= image[0].length) return;
        else if(image[sr][sc] != orcolor) return;
        else if (image[sr][sc] == color) return;
        image[sr][sc] = color;
        solve(image , sr+1, sc ,color, orcolor);// down
        solve(image , sr-1, sc ,color, orcolor);//up
        solve(image , sr, sc+1 ,color, orcolor);//right
        solve(image , sr, sc-1 ,color, orcolor);//left
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orcolor = image[sr][sc];
         solve(image , sr, sc ,color,orcolor);
         return image;
    }
}


// 2. Lowest Common Ancestor of a Binary Search Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}


// 3. Balanced Binary Tree

class Solution {

    public boolean isBalanced(TreeNode root) {
        return heightDiff(root) != -1;
    }

    public int heightDiff(TreeNode root) {
        if (root == null) return 0;
        int left = heightDiff(root.left);
        int right = heightDiff(root.right);
        if (left == -1) return -1;
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}