// 1. Preorder to Postorder

class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node bst(int pre[], int bound, int[]i){
        if (i[0] == pre.length || pre[i[0]] > bound) {
            return null;
        }
        Node root = new Node(pre[i[0]++]);
        root.left = bst(pre, root.data, i);
        root.right = bst(pre, bound, i);
        return root;
    }
    public Node Bst(int pre[], int size) {
        // code here
        return bst(pre, Integer.MAX_VALUE, new int[]{0});
    }
}


// 2. Count BST nodes that lie in a given range 

class Solution {
 int getCount(Node root,int l, int h)
    {
        //Your code here
        
        if(root == null) return 0;
        
        if(l <= root.data && root.data<=h){
            return getCount(root.left, l, h) + getCount(root.right, l, h)+1;
        }else if(root.data < l){
            return getCount(root.right, l, h);
        }else{
            return getCount(root.left, l, h);
        }
    }
}


// 3. Populate Inorder Successor for all Nodes

class Solution {
    public void populateNext(Node root) {
        // code here
        List<Node> li = new ArrayList<>();
        addNode(root,li);
        
        Node temp = new Node(-1);
        li.add(temp);
        
        for(int i = 0;i<li.size()-2;i++){
           li.get(i).next = li.get(i+1);
        }
        
    }
    
    public Node addNode(Node node, List<Node> li){
        if(node == null) return null;
        
        addNode(node.left,li);
        li.add(node);
        addNode(node.right,li);
    return null;
    }
}


// 4. Replace every element


class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        TreeSet<Integer> set = new TreeSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.add(-1);
        set.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]<set.first()){
                result.add(set.first());
            }
            else if(arr[i]>=set.last()){
                result.add(-1);
            }
            else{
               result.add(set.higher(arr[i])); 
            }
            set.add(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }
}