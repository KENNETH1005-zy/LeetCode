class Solution {
    public boolean canPartition(int[] nums) {
        //calculate the sum
        //sum is to find the sum/2
        //create an array with length of that target
        //starting from the back, if the current target can be found, make 
        //that true
        int sum  = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum  % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int j = target; j>= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}