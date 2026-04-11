class Solution {
    public boolean canJump(int[] nums) {
        //record the currJump max and overall max
        //if currJump max is more or equal to last one
        //return true, immediately
        //else just update the maxJump
        int currMax = nums[0];
        int maxJump = nums[0];

        for (int i = 0; i<nums.length - 1; i++) {
            if (currMax >= nums.length - 1) {
                return true;
            }
            currMax = Math.max(nums[i] + i, currMax);
            maxJump = Math.max(currMax, maxJump);
        }
        return false;
    }
}