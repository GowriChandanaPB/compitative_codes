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