class Solution {
    public int coinChange(int[] coins, int amount) {
        //create an array, length is from 0 to amount
        //for each element in the array, it represents the min number of coins
        //to reach that elements
        //iterate trough from 0 to max amount
        //iterate all coins to impelement the current money
        //if the final number of coins of the amount is more than
        //amount, return -1. if not return that nums
        //because it is im, to use more than amount num of coins, to build
        //the amount, the smallest coins size is 1

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //0 amount dont need any coins
        dp[0] = 0;
        for (int i = 1; i<= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}