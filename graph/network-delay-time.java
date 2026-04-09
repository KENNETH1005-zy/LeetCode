class Solution {
    //{time, neighbor node}
    Map<Integer, List<int[]>> map = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        //dp
        //implement
        //return max
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[k] = 0;
        for (int[] time: times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            //{time, neighbor node}
            map.get(time[0]).add(new int[]{time[2], time[1]});
        }
        helper(dp, 0, k);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i<= n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result == Integer.MAX_VALUE  ? -1 : result;
    }
    //helper function
    //add initial
    //while pq not null
    //if new time is shorter, update
    public void helper(int[] dp, int time, int source) {
        //pq to store the earliest arrived node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{time, source});
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int currNode = temp[1];
            int currTime = temp[0];
            if (currTime > dp[currNode]) continue;
            if (!map.containsKey(currNode)) continue;

            for (int[] neighbor: map.get(currNode)) {
                int neighborNode = neighbor[1];
                int nextTime = neighbor[0];

                if (dp[neighborNode] > currTime + nextTime) {
                    dp[neighborNode] = currTime + nextTime;
                    pq.offer(new int[]{dp[neighborNode], neighborNode});
                }
            }
        }
    }
}