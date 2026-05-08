class Solution {
    public int longestOnes(int[] nums, int k) {
        //two pointers
        //record the current used k nums
        //record the max length
        int l = 0;
        int curr = 0;
        int result = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                curr++;
            }
            while (curr > k) {
                if (nums[l] == 0) {
                    curr--;
                }
                l++;
            }
            result = Math.max(r - l + 1, result);
        }
        return result;
    }
}