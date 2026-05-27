class Solution {
    public int combinationSum4(int[] nums, int target) {
        //use an array, has indices from 0 to target
        //find every how many combinations it has for every index
        //index = 4, [4] = how many combination it has to construct 4
        //starting from the 0 
        //return [target]
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i<=target; i++) {
            for (int num: nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}