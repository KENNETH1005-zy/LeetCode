class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
    int m;
    int n;
    public int minimumEffortPath(int[][] heights) {
        //priorityqueue can make the smaller diff polled first
        //once reach the destination, return the curr.diff
        //graph to store each min diff from prev node
        //pq to store the smallest poll
        //if meet des, return earlier
        //return [][]des at last
        m = heights.length;
        n = heights[0].length;
        int[][] graph = new int[m][n];
        for (int[] each: graph)
            Arrays.fill(each, Integer.MAX_VALUE);
        graph[0][0] = 0;
        //{row, col, diff with prev node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int currR = temp[0];
            int currC = temp[1];
            int diff = temp[2];
            visited[currR][currC] = true;
            if (currR == m - 1 && currC == n - 1) {
                return diff;
            }

            for (int[] dir: dirs) {
                int neighborR = currR + dir[0];
                int neighborC = currC + dir[1];

                if (!valid(neighborR, neighborC) || visited[neighborR][neighborC]) {
                    continue;
                }
                int currDiff = Math.abs(heights[currR][currC] - heights[neighborR][neighborC]);
                int maxDiff = Math.max(currDiff, graph[currR][currC]);

                if (graph[neighborR][neighborC] > maxDiff) {
                    graph[neighborR][neighborC] = maxDiff;
                    pq.add(new int[]{neighborR, neighborC, maxDiff});
                }
            }
        }
        return graph[m - 1][n - 1];
    }
    public boolean valid(int r, int c) {
        return r >= 0 && r < m && c >=0 && c < n;
    }
}