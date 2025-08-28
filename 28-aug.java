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