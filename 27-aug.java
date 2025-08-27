// 1. Number of Operations to Make Network Connected

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; 
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] c : connections) {
            int p1 = findParent(parent, c[0]);
            int p2 = findParent(parent, c[1]);
            if (p1 != p2) {
                parent[p1] = p2; 
                components--;
            }
        }
        return components - 1; 
    }
    private int findParent(int[] parent, int i) {
        while (i != parent[i]) i = parent[i];
        return i; 
    }
}


// 2. Topological Sort

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges){
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int n: adj.get(node)){
                indegree[n]--;
                if(indegree[n] == 0){
                    q.offer(n);
                }
            }
        }
        return res;
    }
}


// 3. Minimum time taken by each job to be completed given by a Directed Acyclic Graph

class Solution {
    public static int [] minimumTime(int n,int m, int[][] edges) {
        
        int indeg[] = new int[n+1];
        for(int i=0;i<edges.length;i++){
            indeg[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int arr[] = new int[n+1];
        
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                q.add(i);
                arr[i] = 1;
            }
        }
        
        while(!q.isEmpty()){
            int val = q.poll();
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]>val){
                    break;
                }
                if(edges[i][0] == val){
                    indeg[edges[i][1]]--;
                    if(indeg[edges[i][1]]==0){
                        q.add(edges[i][1]);
                        arr[edges[i][1]] = arr[val] + 1;
                    } 
                }

            }
        }
        
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = arr[i+1];
        }
        return res;
        
    }
}


// 4. Find whether it is possible to finish all tasks or not from given dependencies

class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i < n; i++)
            arr.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++){
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] inDegree = new int[n];
        for(int i = 0 ; i< n;i++){
            for(Integer it: arr.get(i))
                inDegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0 ; i< n; i++)
            if(inDegree[i] == 0)
                q.add(i);
        ArrayList<Integer> topoSortOrder = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            topoSortOrder.add(node);
            
            for(Integer it: arr.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)
                    q.add(it);
            }
        }
        if(topoSortOrder.size() == n) return topoSortOrder;
        return new ArrayList<Integer>();
    }
}