class Solution {
    public boolean lemonadeChange(int[] bills) {
        //if we get 5, not need to change
        //if 10 find if we have 5
        //if 20, find we have 1 5 and 1 10
        //hashmap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<bills.length; i++) {
            int cash = bills[i];
            if (cash == 5) {
                map.put(cash, map.getOrDefault(cash, 0) + 1);
            }else if (cash == 10) {
                if (!map.containsKey(5) || map.get(5) == 0) {
                    return false;
                }else {
                    map.put(5, map.get(5) - 1);
                    map.put(cash, map.getOrDefault(cash, 0) + 1);
                }
            }else if (cash == 20) {
                if (!map.containsKey(10) || !map.containsKey(5) ||
                    map.get(10) == 0 || map.get(5) == 0) {
                    return false;
                }else {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    map.put(cash, map.getOrDefault(cash, 0) + 1);
                }
            }
        }
        return true;
    }
}