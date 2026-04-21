class Solution {
    public int findPeakElement(int[] nums) {
        //return the index of the peak num
        //for the first and the end, if bigger than just 1 neighbor
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}