class Solution {
    public int lengthOfLongestSubstring(String s) {
        //map to store the index after the current index
        //for starting from the next index
        //if current char is found in map, update the left pointer
        //return the longest
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            map.put(s.charAt(j), j+1);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}