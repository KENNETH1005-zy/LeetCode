class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //use dp [][]
        //store the mat first
        //first time, if it is a 1, find left and top and + 1
        //second time , in reverse, find right and down num
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i< m; i++) {
            for (int j = 0; j<n; j++) {
                dp[i][j] = mat[i][j];
            }
        }
        //first time
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (mat[i][j] == 0) continue;

                //set the minstep as max
                int minStep = m * n;
                if (i > 0) {
                    minStep = Math.min(minStep, dp[i - 1][j]);
                }

                if (j > 0) {
                    minStep = Math.min(minStep, dp[i][j - 1]);
                }
                dp[i][j] = minStep + 1;
            }
        }
        //second time
        for (int i = m - 1; i>= 0; i--) {
            for (int j = n - 1; j>=0; j--) {
                if (mat[i][j] == 0) continue;

                int minStep = m * n;
                if (i < m - 1) {
                    minStep = Math.min(minStep, dp[i + 1][j]);
                }

                if (j < n - 1) {
                    minStep = Math.min(minStep, dp[i][j + 1]);
                }

                dp[i][j] = Math.min(dp[i][j], minStep + 1);
            }
        }
        return dp;
    }
}