class Solution {
    public int minCostClimbingStairs(int[] cost) {
       //one, two means one step before accumulating steps
       int one = 0;
       int two = 0;
       for (int i = 2; i<= cost.length; i++) {
        int temp = one;
        one = Math.min(one + cost[i - 1], two + cost[i - 2]);
        two = temp;
       }
       return one;
    }
}