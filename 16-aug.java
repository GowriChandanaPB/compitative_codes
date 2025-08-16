// 1.Construct Binary Tree from Preorder and Inorder Traversal

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rooti = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                rooti = i;
                break;
            }
        }
        int [] leftpre = Arrays.copyOfRange(preorder, 1, 1 + rooti);
        int [] rightpre = Arrays.copyOfRange(preorder, 1 + rooti, preorder.length);

        int [] leftin = Arrays.copyOfRange(inorder, 0, rooti);
        int [] rightin = Arrays.copyOfRange(inorder, 1 + rooti, inorder.length);

        root.left = buildTree(leftpre, leftin);
        root.right = buildTree(rightpre, rightin);

        return root;
    }
}