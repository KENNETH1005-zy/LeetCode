class Solution {
    char[][] grid;
    public int numIslands(char[][] grid) {
        //if at least one of four dirs is connected, it is the same island
        //dfs to implement the seen array
        //if find a new island, add 1 to the reslt
        this.grid = grid;
        int result = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    result += 1;
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
}