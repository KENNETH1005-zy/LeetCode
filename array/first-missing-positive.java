class Solution {
    public int firstMissingPositive(int[] nums) {
        //cannot use sort
        //iterate the nums
        //starting from 1, find the smallest positive
        //if found increase 1
        //return the smallest
        int smallest = 1;
        int i = 0;
        while (i < nums.length) {
            //if nums[i] <= n
            //swap at the correct location
            //update the smallest
            int correct = nums[i] - 1;
            if (correct < nums.length && correct >= 0 && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else {
                i++;
            }
        }
        //two times
        for (int j = 0; j<nums.length; j++) {
            if (nums[j] == smallest) {
                smallest += 1;
            }
        }
        return smallest;
    }
}