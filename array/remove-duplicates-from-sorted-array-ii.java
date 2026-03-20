class Solution {
    public int removeDuplicates(int[] nums) {
        //using two pointer
        //i for iterating in nums
        //j for the valid index
        int i = 1;
        int j = 1;
        int count = 1;

        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count += 1;
                if (count > 2) {
                    i++;
                    continue;
                }
            }else {
                count = 1;
            }
            nums[j] = nums[i];
            i++;
            j++;
        }
        return j;
    }
}