class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //atmost k distinct nums - atmost k - nums is the result of exactly k
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    //function to detect at most k distinct nums
    public int atMost(int[] nums, int k) {
        //if the size of map is smaller or equal to k, add the count
        //if the size is more than k, shrink the window from the left
        //return the count
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) == 1) {
                k--;
            }
            while (k < 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}