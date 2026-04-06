class Solution {
    public int jump(int[] nums) {
        //set a boundary end, each time, if reach the end, update the boundary
        int currFar = 0;
        int currEnd= 0;
        int result = 0;
        //move before the last num
        for (int i = 0; i< nums.length - 1; i++) {
            //update the current num's max reachable index
            currFar = Math.max(currFar, nums[i] + i);

            //if reach the boundary
            if (i == currEnd) {
                result++;
                //find new boundary
                currEnd = currFar;
            }
        }
        
        return result;
    }
}