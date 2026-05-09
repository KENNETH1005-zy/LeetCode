class Solution {
    public int maxProduct(int[] nums) {
        //current sum and the total sum
        //sum count be bigger
     
        //use the biggest and the smallest
        int smallest = nums[0];
        int biggest = nums[0];
        int result = biggest;
        for (int i = 1; i<nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(nums[i] * biggest, nums[i] * smallest));
            smallest = Math.min(nums[i], Math.min(nums[i] * biggest, nums[i] * smallest));
            biggest = temp;
            result = Math.max(biggest, result);
        }
        return result;
    }
}