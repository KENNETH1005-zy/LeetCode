class Solution {
    public int minPathSum(int[][] grid) {
        //can only go down or right
        //use dp[][] to record the min steps to get to that part
        //start initialize with itself
        //in other part, that has top and left,implement it with the smaller one and add it self
        //once bottom right is implemented, return that
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }else if (i > 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else if (i == 0 && j> 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }

                if (i == m - 1 && j == n - 1) break;
            }
        }
        return dp[m - 1][n - 1];
    }
}