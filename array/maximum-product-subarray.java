class Solution {
    public int maxProduct(int[] nums) {
        // - * - could be positive
        //so need to record smallest num
        //and the biggest num as well
        //global var to store biggest
        int currMin = nums[0];
        int currMax = nums[0];
        int biggest = currMax;
        for (int i = 1; i< nums.length; i++) {
            int curr = nums[i];
            
            //temp max
            int temp_max = Math.max(curr, Math.max(curr * currMin, curr * currMax));
            currMin = Math.min(curr, Math.min(curr * currMin, curr * currMax));
            currMax = temp_max;
            biggest = Math.max(biggest, currMax);
        }
        return biggest;
    }
}