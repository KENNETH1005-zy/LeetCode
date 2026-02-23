class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //if the current sum is equal k, max length is the current index + 1
        //map to store the indice of prefix sum that is equal to k

        //only add the new prefix sum to the map
        //return the max length
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                max = Math.max(max, i + 1);
            }

            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}