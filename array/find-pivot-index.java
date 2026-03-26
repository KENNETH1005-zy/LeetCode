class Solution {
    public int pivotIndex(int[] nums) {
        //prefix array
        //suffix array
        //find the equal index
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        for (int i = 1; i<nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1]; 
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 0;
        for (int i = nums.length - 2; i>= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i + 1];
        }

        for (int i = 0; i<nums.length; i++) {
            if (prefix[i] == suffix[i]) {
                return i;
            }
        }
        return -1;
    }
}