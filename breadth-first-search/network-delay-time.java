class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> map;
    public int networkDelayTime(int[][] times, int n, int k) {
        //relation map to record the source to target
        //map {sourse, {time, dest}}
        //array to store the minmum to arrive at that node
        //array[n + 1] 1 -> n
        //current node time 0
        //get max value in this array
        //return max time

        map = new HashMap<>();
        for (int[] time: times) {
            int s = time[0];
            int d = time[1];
            int t = time[2];

            //if map contains the key add to the value
            //else create a new 
            if (map.containsKey(s)) {
                map.get(s).add(new Pair<>(t, d));
            }else {
                map.put(s, new ArrayList<>());
                map.get(s).add(new Pair<>(t, d));
            }
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        BFS(minTime, k);
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, minTime[i]);
        }
        
        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    //helper function to record and implement the minTime array
    public void BFS(int[] minTime, int source) {
        //q to store the neighbors that appears in relationship map
        Queue<Integer> q = new LinkedList<>();

        //add the current node to the q
        //while q is not empty
        //poll the node out
        //iterate over its neighbors
        //update the minTime
        //if the new time prev minTime is bigger than current time
        //which is the time to current node + time to the neihgbor
        //update the neighbor time

        q.add(source);
        minTime[source] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (!map.containsKey(curr)) {
                continue;
            }

            for (Pair<Integer,Integer> neighbor: map.get(curr)) {
                int timeToNeighbor = neighbor.getKey();
                int neighborNode = neighbor.getValue();

                int arrival = minTime[curr] + timeToNeighbor;
                if (minTime[neighborNode] > arrival) {
                    minTime[neighborNode] = arrival;
                    q.add(neighborNode);
                }
            }
        }
    }
}