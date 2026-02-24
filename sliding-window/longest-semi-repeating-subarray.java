class Solution {
    private static final int[] freq = new int[100001]; //reuse this frequency array each time
    public int longestSubarray(int[] nums, int k) {
        for(int num : nums) freq[num] = 0; //set the relevant values in the frequency array to 0
        
        int left = 0;
        for(int num : nums) {
            if(++freq[num] == 2) k--; //decrease k for each duplicate element we see
            if(k < 0 && freq[nums[left++]]-- == 2) k++; //if k < 0, increment the left pointer, update freq array and k
        }
        return nums.length - left; //size of the max valid range
    }
}