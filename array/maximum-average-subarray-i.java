class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //add up the first k, sum
        //update the new window sum by -nums[first] and + new nums[new]
        //return sum / k
        double sum = 0;

        for (int i = 0; i<k; i++) {
            sum += nums[i];
        }
        double result = sum;
        for (int i = k; i<nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            
            result = Math.max(result, sum);
        }
        return result / k;
    }
}