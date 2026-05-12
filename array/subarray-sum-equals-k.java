class Solution {
    public int subarraySum(int[] nums, int k) {
        //use prefix sum array to store 
        //prefix[i] means the sum before this index in nums
        //use map to store the prefix sum
        //{1,2,3} 
        //{0, 1, 3, 6}
        //iterate prefix sum, if map contains prefix - k
        //add 1 to the result
        int[] prefix = new int[nums.length + 1];
        int result = 0;
        Set<Integer> set = new HashSet<>();
        prefix[0] = 0;
        for (int i = 1; i<prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i<prefix.length; i++) {
            if (set.contains(prefix[i] - k)) {
                result++;
            }
            set.add(prefix[i]);
        }
        return result;
    }
}