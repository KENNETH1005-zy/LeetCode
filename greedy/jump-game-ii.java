class Solution {
    public int jump(int[] nums) {
        //a var to store the maxEnd, which means the max index the prev num can jump
        //a var to store the currEnd, which means the index, the current num can jump
        int maxEnd = 0;
        int currEnd = 0;
        int steps = 0;
        for (int i = 0; i< nums.length - 1; i++) {
            currEnd = Math.max(currEnd, i + nums[i]);

            //only if the current index is reach the prev max end
            if (i == maxEnd) {
                steps++;
                maxEnd = currEnd;
            }
        }
        return steps;
    }
}