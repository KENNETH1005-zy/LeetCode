class Solution {
    public boolean canJump(int[] nums) {
        //from the back to the front
        //update the last index to reach on time
        //if reach the 0th in the num, means it can reach the last one in nums
        int last = nums.length - 1;
        for (int i = nums.length - 1; i>= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}