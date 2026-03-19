class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap of end times

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If no overlap: current start >= last end
            if (pq.isEmpty() || start >= pq.peek()) {
                pq.add(end);
            } else {
                // Overlap: we remove this interval (don't add)
                // But we can optionally replace the one with largest end time?
                // Actually: we want to keep the one with smaller end time!
                // So: if current end < top, replace it to improve future matches
                if (end < pq.peek()) {
                    pq.poll();  // remove the larger end time
                    pq.add(end); // add smaller end time
                }
                // else: keep the old one, ignore current
            }
        }

        // Number of intervals removed = total - kept
        return intervals.length - pq.size();
    }
}