class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //no pq is used
        //sort based on the ending time
        //record the last ending time
        //if new start is more or equal to the last ending
        //update the ending time
        //else add 1 to the count
        //return the count
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        for (int i = 1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= lastEnd) {
                lastEnd = end;
            }else {
                
                count++;
            }
        }
        return count;
    }
}