class Solution {
    public boolean canJump(int[] nums) {
        //it determines, every index we can jump to
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;

        for (int i = 0; i< nums.length; i++) {
            if (!jump[i]) return false;
            int max = nums[i];
            for (int j = i + 1; j<=max + i && j < nums.length; j++) {
                jump[j] = true;
            }
        }
        return jump[nums.length - 1];
    }
}