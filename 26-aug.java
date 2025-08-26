// 1. Rat in a Maze Problem

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return result;
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, "", visited, result);
        Collections.sort(result); // Lexicographical order
        return result;
    }
    private void solve(int row, int col, int[][] maze, int n, String path, boolean[][] visited, ArrayList<String> result) {  
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }
        visited[row][col] = true;
        if (isSafe(row + 1, col, maze, visited, n))
            solve(row + 1, col, maze, n, path + "D", visited, result);
        if (isSafe(row, col - 1, maze, visited, n))
            solve(row, col - 1, maze, n, path + "L", visited, result);
        if (isSafe(row, col + 1, maze, visited, n))
            solve(row, col + 1, maze, n, path + "R", visited, result);
        if (isSafe(row - 1, col, maze, visited, n))
            solve(row - 1, col, maze, n, path + "U", visited, result);
        visited[row][col] = false;
    }

    private boolean isSafe(int row, int col, int[][] maze, boolean[][] visited, int n) {
        return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1 && !visited[row][col];
    }
}


// 2. Steps by Knight

class Solution {
    
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    
    public  int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        if (Arrays.equals(knightPos, targetPos)) {
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {knightPos[0], knightPos[1], 0});  // (x, y, steps)
        
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[knightPos[0]][knightPos[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];
            
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                
                if (newX >= 1 && newX <= N && newY >= 1 && newY <= N && !visited[newX][newY]) {
                    if (newX == targetPos[0] && newY == targetPos[1]) {
                        return steps + 1;
                    }
                    
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY, steps + 1});
                }
            }
        }
        
        return -1;
    }
}


// 3. Clone graph

class Solution {
    HashMap<Integer, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        Node copyNode = new Node(node.val);
        nodes.put(node.val, copyNode);
        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }
        return copyNode;
    }
}