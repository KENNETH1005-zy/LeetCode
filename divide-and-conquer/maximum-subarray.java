class Solution {
    public int maxSubArray(int[] nums) {
        int currSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i< nums.length; i++) {
            currSubarray = Math.max(nums[i], currSubarray + nums[i]);
            maxSubarray = Math.max(maxSubarray, currSubarray);
        }
        return maxSubarray;
    }
}