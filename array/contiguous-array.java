class Solution {
    public int findMaxLength(int[] nums) {
        //find the longest array length for equal count of 1 and 0
        //if meet with 1, add 1, if 0, minus 1
        //every time find the same count, find last one and update the length
        //map to store the index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i] == 1 ? 1 : -1;
            sum += current;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }else {
                result = Math.max(result, i - map.get(sum));
            }
        }
        return result;
    }
}