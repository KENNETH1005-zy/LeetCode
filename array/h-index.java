class Solution {
    public int hIndex(int[] citations) {
        //sort the nums
        //from 0-index
        //when the [i] and length - index is the same return the count
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) {
                return length - i;
            }
        }
        return 0;
    }
}