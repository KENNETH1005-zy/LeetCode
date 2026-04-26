class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //find the intersections
        //sort the intervals
        //use pq to store the ending time for each intervals
        //with the earliest finish time
        //record the max size of pq
        //return the size
  
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        pq.add(intervals[0][1]);

        for (int i = 1; i<intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
                pq.add(intervals[i][1]);
            }else {
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}