class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int count = 0; // number of distinct values that are duplicated (appear > 1 time)
        int max = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            // If this is the first time this number becomes duplicated (i.e., goes from 1 → 2)
            if (map.get(num) == 2 && !set.contains(num)) {
                count++;
                set.add(num);
            }

            // Shrink window while more than k distinct numbers are duplicated
            while (count > k) {
                int leftNum = nums[left];
                int oldCount = map.get(leftNum);
                int newCount = oldCount - 1;

                map.put(leftNum, newCount);

                // If it drops from 2 → 1, it's no longer duplicated
                if (oldCount == 2) {
                    count--;
                    set.remove(leftNum);
                }

                // Remove key if count becomes 0
                if (newCount == 0) {
                    map.remove(leftNum);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}