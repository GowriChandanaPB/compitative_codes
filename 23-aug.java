// 1. BFS

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); 
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>(); 
        ArrayList<Integer> res = new ArrayList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();         
            res.add(node);  

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; 
                    q.add(neighbor);
                }
            }
        }

        return res;
    }
}