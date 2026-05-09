class Solution {
    public int maxProfit(int[] prices) {
        //one stock can only be held for once
        //buy from the lowest, and sell at biggest
        //need to find the biggest gap
        //there could not be intertersetion between the each by and sell

        //total min, and max
        //current min, and max
        //buy must be in front of sell
        //total sum
        //if prev buy is smaller than current sell, add the gap to the total profit
        //and reset the buy as the current buy as prev buy
        //if find a bigger one ,set the current sell as the prev buy, which means, update the buy num

        int buy = 0;
        int result = 0;

        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }else if (prices[buy] < prices[sell]) {
                result += prices[sell] - prices[buy];
                buy = sell;
            }
        }
        return result;
    }
}