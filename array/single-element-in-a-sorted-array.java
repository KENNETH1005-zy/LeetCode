class Solution {
    public int singleNonDuplicate(int[] nums) {
        //find single element
        //using the even index
        //if the prev is equal to the current num, go to right to find the single one
        //if not equal, go to left to find others
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left ) / 2;

            if (mid % 2 != 0) {
                mid = mid - 1;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
}