class Solution {
    public int rob(int[] nums) {
        //bottum up
        //create a dp array
        //store the max along the way
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        //the last one is the max 
        return dp[nums.length - 1];
    }
}