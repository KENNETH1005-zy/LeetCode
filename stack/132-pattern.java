class Solution {
    public boolean find132pattern(int[] nums) {
        //order of index is i,j,k
        //but the num is i, k, j
        //return true of exist such a pattern
        
        //find the i, j, k pattern
        if (nums.length < 3) return false;

        for (int i = 0; i<=nums.length - 3; i++) {
            if(nums[i] < nums[i + 1] && nums[i] < nums[i + 2] && nums[i + 2] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}