class Solution {
    public int maxSubArray(int[] nums) {
        //two options
        //one for current num, another for current sum + num
        //update the max sum
        int current = nums[0];
        int total = nums[0];
        for (int i = 1; i<nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            total = Math.max(current, total);
        }
        return total;

    }
}