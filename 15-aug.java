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
