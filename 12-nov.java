// 1. Binary Tree Level Order Traversal

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> subAns = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode p = q.poll();
                subAns.add(p.val);
                if(p.left != null) q.add(p.left);
                if(p.right != null) q.add(p.right);
            }
            ans.add(subAns);
        }
        return ans;
    }
}


// 2. Clone Graph

class Solution {
    HashMap<Integer, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        Node copyNode = new Node(node.val);
        nodes.put(node.val, copyNode);
        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }
        return copyNode;
    }
}