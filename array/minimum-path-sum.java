class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
       //fron top left to bottom right
       //return the min sum
       //use an next array to store the min path sum to that cell
       //everytime reach the bottom right update the result
       //return the min one
       dp = new int[grid.length][grid[0].length];
       dp[0][0] = grid[0][0];
       
       for (int i = 0; i<grid.length; i++) {
           for (int j = 0; j <grid[0].length; j++) {
            if (i == 0 && j > 0) {
                //if in the 0th row and more than 0th col
                dp[i][j] = dp[i][j - 1] + grid[i][j];
            }else if (i > 0 && j == 0) {
                //if in the 0th col
                dp[i][j] = dp[i - 1][j] + grid[i][j];
            }else if (i > 0 && j > 0) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                break;
            }
           }
       }
       return dp[grid.length - 1][grid[0].length - 1];
    }
    
}