class Solution {
    public int numDistinctIslands(int[][] grid) {
        //only the different shape can be considered as the diff islands
        //use lettes to name the islands
        //L,R,U,D
        //use set to store the string name islands
        //return the set size
        Set<String> set = new HashSet<>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                StringBuilder sb = new StringBuilder();
                dfs(i, j,seen, grid, sb );
                if (sb.length() == 0) continue;
                set.add(sb.toString());
            }
        }
        return set.size();
    } 
    public void dfs(int i, int j, boolean[][] seen, int[][] grid, StringBuilder sb) {
        if (i <0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] != 1) {
            return;
        }
        seen[i][j] = true;
        dfs(i - 1, j, seen, grid, sb.append('U'));
        dfs(i, j - 1, seen, grid, sb.append('L'));
        dfs(i + 1, j, seen, grid, sb.append('D'));
        dfs(i, j + 1, seen, grid, sb.append('R'));
    }
}