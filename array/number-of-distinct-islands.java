class Solution {
    boolean[][] visited;
    int[][] grid;
    StringBuilder current;
    public int numDistinctIslands(int[][] grid) {
        //store the path as chars to the set
        //return the set length
        //dfs to find the path
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                //initialize in every iteration
                current = new StringBuilder();
                dfs(i, j, '0');
                if (current.length() == 0) {
                    continue;
                }
                set.add(current.toString());
            }
        }
        return set.size();
    }
    //helper function
    public void dfs(int i, int j, char dir){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        current.append(dir);
        dfs(i + 1, j, 'D');
        dfs(i, j + 1, 'R');
        dfs(i - 1, j, 'U');
        dfs(i, j - 1, 'L');
        current.append('0');
    }
}