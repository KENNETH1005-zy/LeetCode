class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //use sliding window
        //iterate through the nums, from 0 to nums.length - k
        //maintain the max average in the window
        //update the max
        //return the max
        double result = Double.MIN_VALUE;

        for (int i = 0; i<=nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j<i+k; j++) {
                sum += nums[j];
            }
            result = Math.max(result, (double) sum / k);
        }
        return result;
    }
}