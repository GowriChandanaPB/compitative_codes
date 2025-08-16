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


// 4. Top View of Binary Tree

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer, Integer[]> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        top(root, map, 0, 0);
        for(Integer[] i: map.values()){
            ans.add(i[1]);
        }
        return ans;
    }
    public static void top(Node root,TreeMap<Integer,Integer[]> map, int c,int r){
        if(root==null){return;}
        
        map.putIfAbsent(c,new Integer[]{r,root.data});
        if(map.get(c)[0]>r){
            map.remove(c);
            map.put(c,new Integer[]{r,root.data});
        }
        
        top(root.left,map,c-1,r+1);
        top(root.right,map,c+1,r+1);
    }
}


// 5. Bottom View of Binary Tree 

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, int[]> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        for(int key : map.keySet()){
            ans.add(map.get(key)[0]);
        }
        return ans;
    }
    private void dfs(Node root, TreeMap<Integer, int[]> map, int hd, int depth){
        if(root == null) return;
        if(!map.containsKey(hd) || depth>=map.get(hd)[1]){
            map.put(hd, new int[]{root.data, depth});
        }
        dfs(root.left, map, hd-1, depth+1);
        dfs(root.right, map, hd+1, depth+1);
    }
}


// 6. Diagonal Traversal of Binary Tree 

class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans= new ArrayList<>();
           if(root==null){
               return ans;
           }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node curr = q.poll();
                while(curr!=null){
                    ans.add(curr.data);
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    curr = curr.right;
                }
            }
            return ans;
      }
}


// 7. Duplicate subtree in Binary Tree

class Solution {
    HashSet<String> hs=new HashSet<>();
    int dupSub(Node root) {
        if(solve(root).equals("#")) return 1;
        else return 0;
    }
    public String solve(Node root)
    {
        String s="";
        if(root==null)
            return "$";
        String ls=solve(root.left);
        if(ls.equals("#"))
            return "#";
        String rs=solve(root.right);
        if(rs.equals("#"))
            return "#";
        s=root.data+"/"+ls+"_"+rs;
        String r=Integer.toString(root.data);
        if(s.length()>r.length()+4 && hs.contains(s))
            return "#";
        hs.add(s);
        return s;
    }
}


// 8. Minimum swap required to convert binary tree to binary search tree

