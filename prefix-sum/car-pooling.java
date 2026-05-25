class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //return true if in any time, the num of passengers are not more than cap
        //use the last place to create an array
        //in start index + current passengers
        //if the to is smaller than the last index, 
        //[to] -= passengers
        //use sum to recored the total running passengers
        //start over, update the [current] as the sum
        //if any of it is more than cap, return false
        //else return true
        int last = 0;
        for (int[] trip: trips) {
            last = Math.max(last, trip[2]);
        }
        int[] result = new int[last + 1];

        for (int i = 0; i<trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            result[start] += num;
            if (end < result.length - 1) {
                result[end] -= num;
            }
        }
        int sum = 0;
        for (int i = 0; i<result.length; i++) {
            sum += result[i];
            result[i] = sum;
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}