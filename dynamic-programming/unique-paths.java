class Solution {
    //pass by value, available to add up every time meets a new  path
    int[] count;
    int[][] dirs = new int[][]{{0,1}, {1,0}};

    public int uniquePaths(int m, int n) {
        //dfs, backtracking, mark the traversed grid as -1
        //if a valid grid, mark as 1
        //out of bounds or, grid visited, backtrack
        //count the time that reach the finish
        int[][] paths = new int[m][n];
        paths[m - 1][n - 1] = 3;//end

        count = new int[]{0};
        dfs(paths, 0, 0);
        return count[0];
    }
    public void dfs(int[][] paths, int r, int c){
        //base case1 out of bounds
        if (r < 0 || r >= paths.length || c < 0 || c >= paths[0].length || paths[r][c] == -1) {
            return;
        }
        //valid, meet the finish
        else if (paths[r][c] == 3) {
            count[0]++;
            return;
        }
        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            
            int temp = paths[r][c];
            paths[r][c] = -1;
            dfs(paths, newR,newC);
            //backtracking
            paths[r][c] = temp;
        }

    }
}