class Solution {
    public int firstUniqChar(String s) {
        //record the count of each char in s
        //find the first count is 1
        Map<Character, Integer> map = new HashMap<>();
 
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}