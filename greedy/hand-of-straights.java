class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //if % is not 0 return false
        //store the num count to the map
        //iterate through hand array
        //starting from the first
        //find the possible start
        //find the next
        //if count is 0, return false
        //return true after all
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int h: hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for (int h: hand) {
            int start = h;
            while (map.getOrDefault(start - 1, 0) > 0) {
                start = start - 1;
            }
            while (start <= h) {
                //suppose current h as the biggest
                while (map.getOrDefault(start, 0) > 0) {
                    for (int next = start; next < start + groupSize; next++) {
                        if (map.getOrDefault(next, 0) == 0) {
                            return false;
                        }
                        map.put(next, map.get(next) - 1);
                    }
                }
                start++;
            }
            
        }
        return true;
    }
}