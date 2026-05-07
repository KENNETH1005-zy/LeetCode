class Solution {
    int[][] dp;
    Map<Integer, Integer> map;
    public boolean canCross(int[] stones) {
        //dp[][] to store {index(max is 2000), prevjump(max is 2000)}
        //-1 not visited, 0, cannt be reached, 1 can be reached
        dp = new int[2001][2001];
        map = new HashMap<>();
        //store the [i] and i, in the map
        //mark all num in dp, as -1, as unvisited
        //return solve, starting from the index 0
        for (int i = 0; i< stones.length; i++) {
            map.put(stones[i], i);
        }

        for (int i = 0; i<2000; i++) {
            //unvisited
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, stones);
    }
    //helper function
    //if reach the end, return true
    //if [i] is not -1, return the current boolean
    //iterate from k - 1, if any if 3 is true, return true

    public boolean solve(int index, int prev, int[] stones) {
        if (index == stones.length - 1) {
            return true;
        }
        if (dp[index][prev] != -1) {
            return dp[index][prev] == 1;
        }
        boolean ans = false;
        //i here is next steps to jump
        for (int i = prev - 1; i<= prev + 1; i++) {
            if (i > 0 && map.containsKey(stones[index] + i)) {
                ans = ans || solve(map.get(stones[index] + i), i, stones);
            }
        }
        dp[index][prev] = (ans ? 1 : 0);
        return ans;
    }
}