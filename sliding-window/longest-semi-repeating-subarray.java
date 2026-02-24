class Solution {
    public int longestSubarray(int[] nums, int k) {
        //map to record the num and its count
        //if containsKey num, means it is a duplicate, count the repeating num + 1
        //if the duplicate num is more than k
        //remove from the left most, if the count of the left is 1, or 0(need to remove from the map), count--
        //update the max length
        //return max length
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        int left = 0;

        int count = 0;
        for (int right = 0; right<nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) > 1) {
                count += 1;
            }

            while (count >k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) <= 1) {
                    count -= 1;
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}