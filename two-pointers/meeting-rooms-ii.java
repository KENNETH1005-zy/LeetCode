class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //sort
        //pq
        //insert end time to pq
        //if the new start time is more than peek(), poll() prev, add new ending time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        pq.add(intervals[0][1]);

        for (int i = 1; i<intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) {
                pq.poll();
                pq.add(intervals[i][1]);
            }else {
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}