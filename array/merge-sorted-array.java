class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //the size of nums1 is m + n
        //last one is m + n - 1
        //iterate from the last one in nums2, and the last one in nums1
        //implement the last one with the bigger one
        //if implement the one in nums2, decrease the pointer in nums2
        //else decrese the pointer in nums1
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p>=0; p--){
            if (p2 < 0) break;
            if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            }else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }
}