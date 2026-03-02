class Solution {
    int[][] grid;
    Set<Pair<Integer, Integer>> current;
    int currentRow;
    int currentCol;
    boolean[][] seen;
    public int numDistinctIslands(int[][] grid) {
        //if the shapes are exactly the same, the two islands are considered to be the same
        //using pair to compare with other index, in the set
        this.grid = grid;
        this.seen = new boolean[grid.length][grid[0].length];

        Set<Set<Pair<Integer, Integer>>> result = new HashSet<>();
        for (int row = 0; row <grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                current = new HashSet<>();
                currentRow = row;
                currentCol = col;
                dfs(row, col);

                if (!current.isEmpty()) {
                    result.add(current);
                }
            }
        }
        return result.size();
    }
    public void dfs(int row, int col) {
        //base case, out of bound
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1 || seen[row][col]) {
            return;
        }
        seen[row][col] = true;
        current.add(new Pair<>(row - currentRow, col - currentCol));
        //find the next valid place
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}