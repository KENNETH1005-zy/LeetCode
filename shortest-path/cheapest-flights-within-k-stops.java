class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //use dest[] to store the min cost for each
        //use k loop to find use under and equal to the current stop
        //to implement the dest[]
        //use temp[] to store the current dest
        //rewrite the dest after loop
        //return [dst]
        int[] dests = new int[n];
        Arrays.fill(dests, Integer.MAX_VALUE);
        dests[src] = 0;
        for (int i = 0; i<= k; i++) {
            int[] temp = Arrays.copyOf(dests, n);
            for (int[] flight: flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if (dests[from] != Integer.MAX_VALUE ) {
                    temp[to] = Math.min(dests[from] + cost, temp[to]);
                }
            }
            dests = temp;
        }
        return dests[dst] == Integer.MAX_VALUE ? -1 : dests[dst];
    }
}