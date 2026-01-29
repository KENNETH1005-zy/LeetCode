class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        //change the order with nums1[i] - nums2[i] + (nums1[j] - nums2[j])> 0
        //sanity check
        if (nums1.length != nums2.length) return -1;
        long count = 0;
        int[] s1 = new int[nums1.length];
        for (int i = 0; i<nums1.length; i++) {
            s1[i] = nums1[i] - nums2[i];
        }
        for (int i = 0; i<s1.length - 1; i++) {
            for (int j = i+1; j<s1.length; j++) {
                if (s1[i] + s1[j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}