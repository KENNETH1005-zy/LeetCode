class Solution {
    public int coinChange(int[] coins, int amount) {
        //use array to store the min numbers to make up that amount money
        //for ex: [amount] means min count to make up amount
        int[] dp = new int[amount + 1];
        //fill the dp with min value
        Arrays.fill(dp, amount +1);
        dp[0] = 0;
        for (int i = 1; i<= amount; i++) {
            //iterate to find the fittable coint
            for(int j = 0; j< coins.length; j++) {
                //only update the dp if the coin is smaller than current amount
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}