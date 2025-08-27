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