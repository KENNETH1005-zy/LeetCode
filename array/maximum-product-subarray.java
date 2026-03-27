class Solution {
    public int maxProduct(int[] nums) {
        //brute foce
        //create a result, to record the max in nums
        if (nums.length == 1) return nums[0];
        int result = nums[0];

        for (int i = 0; i<nums.length; i++) {
            int temp = 1;
            for (int j = i; j<nums.length; j++) {
                temp *= nums[j];
                result = Math.max(temp, result);
            }
        }
        return result;
    }
}