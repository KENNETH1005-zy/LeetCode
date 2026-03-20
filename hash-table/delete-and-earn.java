class Solution {
    public int deleteAndEarn(int[] nums) {
        //map to store single num max sum
        //record the max num along the way, as the length of the dp array
        //for each dp array num, record the max sum along the way
        //return the last one in the dp array
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            max = Math.max(num, max);
        }
        int[] dp = new int[max + 1];
        dp[1] = map.getOrDefault(1, 0);

        for (int i = 2; i<= max; i++) {
            int gain = map.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + gain);
        }
        return dp[max];
    }
}