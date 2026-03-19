class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time — critical for greedy correctness
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;           // number of intervals to remove
        int prevEnd = intervals[0][1]; // end time of last accepted interval

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                // Overlap: must remove current interval
                count++;
            } else {
                // No overlap: accept this interval
                prevEnd = end;
            }
        }

        return count;
    }
}