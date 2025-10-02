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


// 2. DFS

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[adj.size()+1];
        ArrayList<Integer> dfs=new ArrayList<>();
        rec(0,adj,vis,dfs);
        return dfs;
    }
    void rec(int i,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> dfs){
        dfs.add(i);
        vis[i]=true;
        for(int j:adj.get(i)){
            if(!vis[j]){
                rec(j,adj,vis,dfs);
            }    
        }
    }
}


// 3. Flood Fill Algorithm

class Solution {
    public void solve(int[][] image, int sr, int sc, int color, int orcolor){
        if(sr < 0 || sc<0 || sr>= image.length || sc>= image[0].length){
            return;
        }
        else if(image[sr][sc]!=orcolor){
            return;
        }
        else if (image[sr][sc] == color) {
            return;
        }
            image[sr][sc]=color;
        solve(image , sr+1, sc ,color, orcolor);
        solve(image , sr-1, sc ,color, orcolor);
        solve(image , sr, sc+1 ,color, orcolor);
        solve(image , sr, sc-1 ,color, orcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orcolor = image[sr][sc];
         solve(image , sr, sc ,color,orcolor);
         return image;
    }
}     


// 4. Detect cycle in a graph

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        
        for (int i=0;i<V;i++)
            if (indeg[i] == 0)
                q.add(i);
                
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int ngbr: adj.get(curr)) {
                indeg[ngbr]--;
                if (indeg[ngbr] == 0)
                    q.add(ngbr);
            }
        }
        
        for (int i=0;i<V;i++)
            if (indeg[i] > 0)
                return true;
                
        return false;
    }
}


// 5. Detect cycle in an undirected graph 

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj) == true) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int src, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[src] = true;
        for (int adjNode : adj.get(src)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, src, vis, adj)) return true;
            } else if (adjNode != parent) return true;
        }
        return false;
    }
}