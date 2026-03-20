class Solution {
    //a map to store max money for each index
    //global nums
    Map<Integer, Integer> map;
    int[] nums;
    public int rob(int[] nums) {
        map = new HashMap<>();
        this.nums = nums;
        //starting from last one to search
        return dp(nums.length - 1);
    }
    //helper function to implement map
    public int dp(int i) {
        //there are two base case, first one and second one
        if (i == 0) return nums[0];
        if (i == 1) return nums[1];

        if (!map.containsKey(i)) {
            map.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i]));
        }
        return map.get(i);
    }
}