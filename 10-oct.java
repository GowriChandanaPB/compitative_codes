// 1. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}


// 2. Course Schedule II

class Solution {
    private List<Integer> output = new ArrayList<>();
    private int[] indegree;
    private List<List<Integer>> adj;

    private void dfs(int node) {
        output.add(node);
        indegree[node]--;
        for (int nei : adj.get(node)) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                dfs(nei);
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }

        if (output.size() != numCourses) return new int[0];
        int[] res = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res;
    }
}