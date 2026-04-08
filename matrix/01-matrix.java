class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        //store the coordinate and the initial path length to q
        //boolean[][] to make every 0 visited
        //while q is not empty
        //poll out the visited set
        //find in valid neighbors, if meet unvisited, add the current path + 1
        //and add it to the q
        //return the implement matrix
        m = mat.length;
        n = mat[0].length;
        int[][] matrix = new int[m][n];

        visited = new boolean[m][n];
        //{row, col, path}
        Queue<int[]> q = new LinkedList<>();
        //store every 0 and make them visited
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    matrix[i][j] = 0;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int[] dir: dirs) {
                int newR = temp[0] + dir[0];
                int newC = temp[1] + dir[1];

                if (!valid(newR, newC)) {
                    continue;
                }
                q.add(new int[]{newR, newC, temp[2] + 1});
                visited[newR][newC] = true;;
                matrix[newR][newC] = temp[2] + 1;
            }
        }
        return matrix;
    }
    public boolean valid(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
            return false;
        }
        return true;
    }
}