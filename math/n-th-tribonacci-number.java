class Solution {
    public int tribonacci(int n) {
        //nth num means n - 1 in the array
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n <= 2) return dp[n];

        for (int i = 3; i<= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}