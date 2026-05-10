class Solution {
    public int findMaxLength(int[] nums) {
        //map to find the last occur of count
        //if meet 1, add 1
        //if 0, -1
        //if find the count that has before
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int result = 0;
        for (int i = 0; i<nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            }else {
                map.put(count, i);
            }
        }
        return result;
    }
}