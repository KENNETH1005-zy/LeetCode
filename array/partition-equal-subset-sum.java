class Solution {
    public boolean canPartition(int[] nums) {
        //option1: add current num to the left
        //opotion2: add current num to the right
        //sum 
        //target is half of the sum
        //if mod is more 0, return false
        //dp array define, each dp[i], means we have found the sum of i
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;//sum of 0 can be found, which means nothing in it

        for (int num: nums) {
            for (int j = target; j>=num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}