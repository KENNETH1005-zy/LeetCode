class Solution {
    public int hIndex(int[] citations) {
        //sort the nums
        //from 0-index
        //when the [i] and length - index is the same return the count
        Arrays.sort(citations);
        int count = 0;
        int length = citations.length;
        if (length == 1 && citations[0] == 0) return 0;
        for (int i = 0; i < length; i++) {
            count = length - i;
            if (count == citations[i]) {
                break;
            }
        }
        return count;
    }
}