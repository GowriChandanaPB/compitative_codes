
// 1. Bipartitie Graph

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
