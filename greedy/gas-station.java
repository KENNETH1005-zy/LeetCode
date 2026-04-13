class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //result to i, meas the stations that have been passed by
        int result = 0;
        //curr gain and the total gain
        int curr = 0;
        int total = 0;

        for (int i = 0; i< gas.length; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            //if total is samller than 0, mean every A to B
            //cannot reach the end
            if (total < 0) {
                result = i + 1;//search for the next station, out of the curr bound
                curr = 0;
            }
        }
        return result;
    }
}