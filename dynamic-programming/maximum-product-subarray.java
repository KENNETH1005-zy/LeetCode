class Solution {
    public int maxProduct(int[] nums) {
        //becase the min and max so far can both be max result 
        //so need to record them along the way

        int max_sofar = nums[0];
        int min_sofar = nums[0];
        int result = max_sofar;

        for (int i = 1; i<nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_sofar * curr, min_sofar * curr));

            min_sofar = Math.min(curr, Math.min(max_sofar * curr, min_sofar * curr));
            //update max
            max_sofar = temp_max;
            result = Math.max(result, max_sofar);
        }
        return result;
    }
}