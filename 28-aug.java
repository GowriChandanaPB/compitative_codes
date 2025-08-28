// 1.  Negative Weighted Cycle

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
       if(edges.length <= 2) return 0;
       int distance[] = new int[n];
       Arrays.fill(distance , Integer.MAX_VALUE);
       distance[edges[0][0]] = 0;
       for(int i = 0; i < n - 1; i++){
           for(int j = 0; j < edges.length; j++){
              int u = edges[j][0];
              int v = edges[j][1];
              int wt = edges[j][2];
              if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]){
                  distance[v] = distance[u] + wt;
              }
           }
       }
       for(int j = 0; j < edges.length; j++){
          int u = edges[j][0];
          int v = edges[j][1];
          int wt = edges[j][2];
          if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]){
              return 1;
          }
       }
       return 0;
    }
}


// 2. Floyd Warshall

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dist[i][k] != (int)1e8 && dist[k][j] != (int) 1e8) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }
        }
    }
}


// 3. Snakes and Ladders

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] min_rolls = new int[n * n + 1];
        Arrays.fill(min_rolls, -1);
        Queue<Integer> q = new LinkedList<>();
        min_rolls[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= 6 && x + i <= n * n; i++) {
                int t = x + i;
                int row = (t - 1) / n;
                int col = (t - 1) % n;
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                int y = (v > 0 ? v : t);
                if (y == n * n) return min_rolls[x] + 1;
                if (min_rolls[y] == -1) {
                    min_rolls[y] = min_rolls[x] + 1;
                    q.offer(y);
                }
            }
        }
        return -1;
    }
}


// 4. Kosaraju's Theorem

class Solution{
    
    Stack<Integer> tSort;
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        tSort = new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,vis,true);
            }
        }
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<V;i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(Integer j:adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        vis=new boolean[V];
        int res=0;
        while(!tSort.isEmpty()){
            int pop=tSort.pop();
            if(!vis[pop]){
                res++;
                dfs(transpose,pop,vis,false);
            }
        }
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int start,boolean vis[],boolean first_dfs){
        vis[start]=true;
        for(Integer nbr:adj.get(start)){
            if(!vis[nbr]){
                dfs(adj,nbr,vis,first_dfs);
            }
        }
        if(first_dfs)   tSort.push(start);
    }
}


// 5. Vertex Cover

class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        // code here
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = true;
            graph[edge[1] - 1][edge[0] - 1] = true;
        }

        boolean[] visited = new boolean[n];
        int minCoverSize = n;  

        minCoverSize = findMinCover(graph, visited, 0, 0, minCoverSize);

        return minCoverSize;
    }

    private static int findMinCover(boolean[][] graph, boolean[] visited, int start, int size, int minCoverSize) {
        if (start == graph.length) {
            if (isVertexCover(graph, visited) && size < minCoverSize) {
                minCoverSize = size;
            }
            return minCoverSize;
        }
        minCoverSize = findMinCover(graph, Arrays.copyOf(visited, visited.length), start + 1, size, minCoverSize);
        visited[start] = true;
        minCoverSize = findMinCover(graph, Arrays.copyOf(visited, visited.length), start + 1, size + 1, minCoverSize);
        return minCoverSize;
    }

    private static boolean isVertexCover(boolean[][] graph, boolean[] visited) {
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph[u].length; v++) {
                if (graph[u][v] && !(visited[u] || visited[v])) {
                    return false;
                }
            }
        }
        return true;
    }
}