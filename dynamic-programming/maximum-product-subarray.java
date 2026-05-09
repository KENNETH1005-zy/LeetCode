class Solution {
    public int maxProduct(int[] nums) {
        //current sum and the total sum
        int current = nums[0];
        int total = nums[0];
        for (int i = 1; i<nums.length; i++) {
            current = Math.max(nums[i], current * nums[i]);
            total = Math.max(total, current);
        }
        return total;
    }
}