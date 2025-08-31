// 1. Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stop = 0;
        while (!q.isEmpty() && stop <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stop++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}


// 2. Find if there is a path of more than k length from a source

class Solution{
    
    boolean pathMoreThanK(int V, int E, int K, int[] A) {
        HashMap<Integer, ArrayList<Integer[]>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < A.length-1 ; i += 3) {

            int a = A[i];
            int b = A[i + 1];
            int weight = A[i + 2];

            Integer[] edge1 = new Integer[] { b, weight };
            Integer[] edge2 = new Integer[]{ a , weight};

            graph.get(a).add(edge1 );
            graph.get(b).add( edge2 );
        }
        int start = A[A.length - 1];

        boolean[] visited = new boolean[V];
        int sumOfPath = 0;

        boolean Found = dfs( start , sumOfPath, K , graph , visited );

        if( Found ){
            return true;
        }
        return false;
    }

    public boolean dfs( int currentVertex , int sumOfPath , int K , HashMap<Integer,ArrayList<Integer[]>> graph , boolean[] visited ){

        if( sumOfPath >= K ){
            return true;
        }
        visited[ currentVertex ] = true;
        for( Integer[] edge : graph.get( currentVertex) ){

            int neighbour = (int)edge[0];
            int weight = (int) edge[1];

            if( visited[ neighbour] == false ){

                boolean found = dfs( neighbour , sumOfPath+weight , K , graph , visited );
                if( found ){
                    return true;
                }
            }
        }
        visited[ currentVertex ] = false;
        return false;

    }
    
}


// 3. Bellman Ford

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


// 4. Bipartitie Graph

class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int col[]=new int[V];
        Arrays.fill(col,-1);
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer> > list=new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            list.get(src).add(dest);
            list.get(dest).add(src);
        }
        for(int i=0;i<V;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=1;
            while(!q.isEmpty()){
                int curr=q.poll();
                 int ccol=col[curr];
                for(int c:list.get(curr)){
                    if(col[c]==-1){
                        q.add(c);
                        if(ccol==1){
                            col[c]=2;
                        }else{
                            col[c]=1;
                        }
                    }else{
                       if (ccol==col[c]){
                           return false;
                       }
                    }
                }
            }
            }
        }
        return true;
        
    }
}



// 5. Word-Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) continue;
                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
                        if (endSet.contains(newWord)) return steps + 1;
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            nextSet.add(newWord);
                        }
                    }
                }
            }
            beginSet = nextSet;
            steps++;
        }
        return 0;     

    }
}