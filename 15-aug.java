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


// 5.Binary Tree Level Order Traversal

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> subAns = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode p = q.poll();
                subAns.add(p.val);
                if(p.left != null){
                    q.add(p.left);
                }
                if(p.right != null){
                    q.add(p.right);
                }
            }
            ans.add(subAns);
        }
        return ans;
    }
}


// 6.Left View of Binary Tree

class Solution {
   ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer>list=new ArrayList<>();
        leftV(root,list,0);
        return list;
        
    }
    
    public static void leftV(Node root,ArrayList<Integer> list,int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        leftV(root.left,list,level+1);
        leftV(root.right,list,level+1);
        
    }
}


// 7. Right View of Binary Tree

class Solution {
   ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer>list=new ArrayList<>();
        leftV(root,list,0);
        return list;
        
    }
    
    public static void leftV(Node root,ArrayList<Integer> list,int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        leftV(root.right,list,level+1);
        leftV(root.left,list,level+1);
        
    }
}