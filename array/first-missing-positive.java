class Solution {
    public int firstMissingPositive(int[] nums) {
        //iterate the nums
        //starting from 1, find the smallest positive
        //if found increase 1
        //return the smallest
        int smallest = 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == smallest) {
                smallest += 1;
            }
            i++;
        }
        return smallest;
    }
}