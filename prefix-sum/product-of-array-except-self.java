class Solution {
    public int[] productExceptSelf(int[] nums) {
        //run two times
        //first dp array to store running sum to the left of i - 1
        //dp[0] is 1 cause there is no left of 0th num
        //then use a variable to record the running sum to the right of ith num
        //time it to the dp[]array
        //return the dp array
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i<nums.length; i++) {
            dp[i] = dp[i - 1] * nums[i - 1];
        }
        int R = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = dp[i] * R;
            R *= nums[i];
        }
        return dp;
    }
}