class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] distance = new int[1001];
        for (int[] trip: trips) {
            distance[trip[1]] += trip[0];
            distance[trip[2]] -= trip[0];
        }
        int people = 0;
        for (int temp: distance) {
            people += temp;
            if (people > capacity) return false;
        }
        return people <= capacity;
    }
}