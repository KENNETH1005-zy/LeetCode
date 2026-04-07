class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        //find in four dirs, if there is a 1, consider it as a land
        //make it as -1, and find a new land
        int islands = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int r, int c) {
        //base case
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1 , c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}