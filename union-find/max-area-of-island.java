class Solution {
    //boolean[][] to detect whether is visited before
    boolean[][] visited;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        return result;
    }

    public int dfs(int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j) + dfs(i, j + 1) + dfs(i - 1, j) + dfs(i, j - 1) + 1;
    }
}