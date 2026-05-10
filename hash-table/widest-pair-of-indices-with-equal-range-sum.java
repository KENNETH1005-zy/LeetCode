class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        //use translate prob into sum(nums1(i -> j)) - sum(nums2(i -> j)) = 0
        //make the j - i the biggest
        //map to store the last occurrance of set
        //intial 0 with -1
        //sum of the minus\
        Map<Integer, Integer> map = new HashMap<>();
        //{difference, prev occurrance}
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for(int i = 0; i<nums1.length; i++) {
            int diff = nums1[i] - nums2[i];
            sum += diff;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return result;
    }
}