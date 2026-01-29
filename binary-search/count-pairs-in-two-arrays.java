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
        Arrays.sort(s1);
        
        for (int i = 0; i< s1.length; i++) {
            if (s1[i] > 0) {
                count += s1.length - i - 1;
            }else {
                int left = i+1;
                int right = s1.length - 1;
                //find the first one that is valid
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (s1[mid] + s1[i] > 0) {
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                count += s1.length - left;
            }
        }
        return count;
    }
}