class Solution {
    public int jump(int[] nums) {
        //record the curr jump and the minx jump
        //if reach the end, break it
        //and return the min jump
        int curr = 0;
        int maxSofar = 0;
        int steps = 0;

        for (int i = 0; i< nums.length - 1; i++) {
            curr = Math.max(curr, i + nums[i]);

            if (i == maxSofar) {
                steps++;
                maxSofar = curr;
            }
        }
        return steps;
    }
}