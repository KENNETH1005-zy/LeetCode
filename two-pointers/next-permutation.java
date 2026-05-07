class Solution {
    public void nextPermutation(int[] nums) {
        //find the most recent bigger permutation
        //if no bigger, return the smallest
        //start from the last one
        //find the one that is smaller, before it
        //if no smaller before it, return the smallest
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //swap the [i + 1] > [i]
        //reverse rest of the array
        //from the last one, find the num that is just bigger than[i]
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(i, j, nums);
        }
        reverse(i + 1, nums);
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int i, int[] nums) {
        int s = i;
        int e = nums.length - 1;

        while (s < e) {
            swap(s, e, nums);
            s++;
            e--;
        }
    }
}