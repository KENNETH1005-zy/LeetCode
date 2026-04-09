class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //bellman ford
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[k] = 0;

        for (int i = 1; i<n; i++) {
            boolean changed = false;
            for (int[] time:times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if (dp[u] != Integer.MAX_VALUE && dp[u] + w < dp[v]) {
                    dp[v] = dp[u] + w;
                    changed = true;
                }
            }
            if (!changed) break;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i<=n; i++) {
            if (dp[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}