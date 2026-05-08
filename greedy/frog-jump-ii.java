class Solution {
    public int maxJump(int[] stones) {
        // First possible jump contributes to max.
        int ans = stones[1] - stones[0];

        // Check all skip-one gaps.
        for (int i = 2; i < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }

        return ans;
    }
}