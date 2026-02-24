class Solution {
    public boolean canArrange(int[] arr, int k) {
        //use map to store the remainder and its count
        //iterate every arr, if the rem is 0 but the count is not even return false
        //if the rem and k - rem count is not the same return false
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: arr) {
            int rem = (i % k + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int i: arr) {
            int rem = (i % k + k) % k;

            if (rem == 0) {
                if (map.get(rem) % 2 == 1) return false;
                
            }else if ( rem < k - rem && map.get(rem) != map.get(k - rem)) return false;
        }
        return true;
    }
}