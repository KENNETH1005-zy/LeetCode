class Solution {
    public int search(int[] nums, int target) {
        //binary search
        //while l < = right
        //if left to mid is sorted
            //if target is in between left and mid, search in left
            //else search in right
        //else if right to mid is sorted
            //if targhet is in between mid to right, search in right
            //else just move to left to search
        int l = 0; 
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else if (nums[mid] <= nums[r]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}