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


// 2. Height of Binary Tree 

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null){
            return -1;
        }
        int l = height(node.left);
        int r = height(node.right);
        int hig = 1 + Math.max(l, r);
        return hig;
    }
}


// 3. Diameter of a Binary Tree

class Solution {
    private int height(Node root,int[] ans){
        if(root==null)return 0;
        int l=height(root.left,ans);
        int r=height(root.right,ans);
        ans[0]=Math.max(ans[0], l + r);
        return Math.max(l, r)+1;
    }
    int diameter(Node root) {
        int maxd[]=new int[1];
        height(root,maxd);
        return maxd[0];
    }
}
