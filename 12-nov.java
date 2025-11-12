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


// 3. Evaluate Reverse Polish Notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")) stk.push(stk.pop() + stk.pop());
            else if(c.equals("-")){
                int sec = stk.pop();
                int fir = stk.pop();
                stk.push(fir - sec);
            } else if (c.equals("*")) stk.push(stk.pop() * stk.pop());
             else if(c.equals("/")){
                int sec = stk.pop();
                int fir = stk.pop();
                stk.push(fir / sec);
            } else stk.push(Integer.parseInt(c));
        }
        return stk.peek();
    }
}


// 4. Course Schedule 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) queue.offer(i);

        int visited = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited++;
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return visited == numCourses;
    }
}


// 5. Implement Trie (Prefix Tree)

class TrieNode {
    boolean end = false;
    TrieNode[] childs = new TrieNode[26];
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.childs[idx] == null)
                node.childs[idx] = new TrieNode();
            node = node.childs[idx];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.childs[idx] == null)
                return false;
            node = node.childs[idx];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if(node.childs[idx] == null)
                return false;
            node = node.childs[idx];
        }
        return true;
    }
}


// 6. Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
            }
        }

        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;        
    }
}