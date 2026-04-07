class Solution {
    public int climbStairs(int n) {
        //an array to store how many ways can reach that step
        //update the array
        //return [n]
        int[] dp = new int[n + 1];
        //dont have to take any stare to climb to 0 step
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //only one way to go from n - 1 to n
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}