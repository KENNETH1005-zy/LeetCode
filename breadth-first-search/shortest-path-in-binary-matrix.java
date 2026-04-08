class Solution {
    int[][] dirs = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1,0}, {1,1}, {-1, 1}, {1, -1},
        {-1, -1}};
    int n;
    boolean[][] visited;
    int[][] grid;
    public int shortestPathBinaryMatrix(int[][] grid) {
        //bfs to search for the end
        //add the current coordinate and the path length, to queue
        //use boolean[][] visited, to define it is visited
        //if reach the end, return the length immediately
        //search for 8 dirs, add 1 more to the length of the path
        //for that coordinate

        this.grid = grid;
        n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        //{row, col, length}
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][n];
        
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == n-1 && temp[1] == n-1) {
                return temp[2];
            }
            for (int[] neighbor: getNeighbors(temp[0], temp[1])) {
                //make it visited, and search for other neighbor
                int r = neighbor[0];
                int c = neighbor[1];
                visited[r][c] = true;
                q.add(new int[]{r, c, temp[2] + 1});
            }
        }
        return -1;
    }
    //function to get the valid neighbors
    public List<int[]> getNeighbors(int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        //{row, col} for the valid neighbor
        for (int[] dir: dirs) {
            int newR = row + dir[0];
            int newC = col + dir[1];
            //if out of bounds, just skip
            //or is not 0
            if (newR < 0 || newR >= n || newC < 0 || newC >= n || grid[newR][newC]
                != 0 || visited[newR][newC]) {
                continue;
            }
            neighbors.add(new int[]{newR, newC});
        }
        return neighbors;
    }
}