class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //three pointers
        //p1 and p2
        //another pointer from the last one in nums1, to 0th
        //compare nums at p1 and p2, implement the bigger one, and decrease that pointer
        //if p2 < 0, break, no more to manipulate
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
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