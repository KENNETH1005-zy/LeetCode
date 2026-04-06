class Solution {
    public int maxProduct(int[] nums) {
        //an int to update min
        //and the maxmum
        int min = nums[0];
        int max = nums[0];
        int result = max;
        //iterate through the nums
        //for each nums[i], update the max with nums[i], and max * nums[i]
        //update the min num
        //return max
        for (int i = 1; i<nums.length; i++) {
            int curr = nums[i];
            //if the current is bigger than prev max, just move to the curr num
            int temp_max = Math.max(curr, Math.max(curr * max, curr * min));
            min = Math.min(curr, Math.min(curr * max, curr * min));
            max = temp_max;
            result = Math.max(max, result);
        }
        return result;
    }
}