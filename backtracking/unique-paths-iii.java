class Solution {
    private int[][] directions = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    //record the num of empty
    //if met obstable, just return
    //if destination return the current path
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int row = -1;
        int col = -1;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }else if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }
        grid[row][col] = -1;
        return dfs(row, col, count, 0, grid);
    }
    public int dfs(int row, int col, int count, int passed, int[][] grid) {
        //base case
        if (grid[row][col] == 2) {
            return passed == count ? 1:0;
        }
        //mark the current as visited
        int temp = grid[row][col];
        grid[row][col] = -1;
        int path = 0;
        for (int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            //if out of bounds, or meets -1, just continue
            //else add the path
            if (newRow <0 || newRow >= grid.length || newCol <0 || newCol >= grid[0].length) {
                continue;
            }
            if (grid[newRow][newCol] != -1) {
                int newPassed = grid[newRow][newCol] == 0? passed+1: passed;
                path += dfs(newRow, newCol, count, newPassed, grid);
            }
        }
        grid[row][col] = temp;
        return path;
    }
}