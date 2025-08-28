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