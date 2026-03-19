class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap of end times

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If there's an overlap with the earliest-ending interval we've kept
            if (!pq.isEmpty() && start < pq.peek()) {
                // Replace the one with the largest end time if current ends earlier
                if (end < pq.peek()) {
                    pq.poll();
                    pq.add(end);
                }
                // Otherwise, skip current
            } else {
                pq.add(end);
            }
        }

        return intervals.length - pq.size();
    }
}