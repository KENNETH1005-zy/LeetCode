class Solution {
    public int coinChange(int[] coins, int amount) {
        //return the fewest
        //create an array that record the min change
        //from 0 to that amount
        //dp[0] is 0
        //implement the coins index, in the dp[]
        //return dp[amount]
        //only implement the array if the current i is bigger or equal to the coin value
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}