class Solution {
    int m;
    int n;
    public int numDistinctIslands(int[][] grid) {
        //the same shape islands are considered to be the same
        //store the relative relationship of the parts
        //use chars to store the islands
        //same shape islands have the same string
        m = grid.length;
        n = grid[0].length;

        Set<String> result = new HashSet<>();
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                StringBuilder current = new StringBuilder();
                dfs(i, j, grid, seen, current);
                if (current.length() == 0) continue;
                result.add(current.toString());
            }
        }
        return result.size();
    }

    public void dfs(int i, int j, int[][] grid, boolean[][] seen, StringBuilder current) {
        //base case
        if (i <0 || i >= m || j <0 || j >= n || seen[i][j] || grid[i][j] != 1) {
            return;
        }
        seen[i][j] = true;
        dfs(i + 1, j, grid, seen, current.append('D'));
        dfs(i, j + 1, grid, seen, current.append('R'));
        dfs(i - 1, j, grid, seen, current.append('U'));
        dfs(i, j - 1, grid, seen, current.append('L'));
    }
}