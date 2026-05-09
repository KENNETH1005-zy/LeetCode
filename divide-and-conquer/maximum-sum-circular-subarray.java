class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //current max and min
        //total max and min
        //kanes approach, and recording total sum
        //if total sum is equal to total min, means all negative
        //return the biggest in nums, which is total max
        //if not, return bigger one in total max, and total sum - total min
        //it means the biggest can translate to total - the min in the middle
        int currentMax = 0;
        int currentMin = 0;
        int totalMax = nums[0];
        int totalMin = nums[0];
        int totalSum = 0;

        for (int num: nums) {
            //if prev is smaller than 0, create a new subarray from the current num
            currentMax = Math.max(currentMax, 0) + num;
            totalMax = Math.max(totalMax, currentMax);

            currentMin = Math.min(currentMin, 0) + num;
            totalMin = Math.min(totalMin, currentMin);
            totalSum += num;
        }

        if (totalSum == totalMin) {
            return totalMax;
        }

        return Math.max(totalMax, totalSum - totalMin);
    }
}