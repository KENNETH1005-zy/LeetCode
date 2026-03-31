class Solution {
    public int lengthOfLIS(int[] nums) {
        //int[]dp to define the length of longest subsequence before this i
        //starting with all 1, because the num it self can be a subsequence
        //for i = 1 , impelement the dp array
        //for j = 0 j < i, to iterate the nums before current i
        //update dp[i] with dp[j] + 1(add itself), and dp[i]
        //iterate the dp array to update the longest
        //return longest

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i< nums.length; i++) {
            for (int j = 0; j<i; j++) {

                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int result = 0;
        for (int num: dp) {
            result = Math.max(result, num);
        }
        return result;
    }
}