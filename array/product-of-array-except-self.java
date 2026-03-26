class Solution {
    public int[] productExceptSelf(int[] nums) {
        //create prefix sum array
        //start from the beginning, caculate mutiple sum before the current i
        //start from the end, cacualte after
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i<nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        int r = 1;
        for (int i = nums.length - 1; i>=0; i--) {
            prefix[i] = prefix[i] * r;
            r *= nums[i];
        }
        return prefix;
    }
}