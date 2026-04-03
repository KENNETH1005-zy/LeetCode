class Solution {
    public int lengthOfLongestSubstring(String s) {
        //longest
        //create a sliding window
        //map to store the char and the index 
        //iterate throught the s, if a new char, continue to make it longer
        //if contains in the map, get the index of it
        //and make the l boudary is that duplicate index + 1
        //update the longest length along the way
        //retur the longest

        int longest = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            //map is null and new char
            if (map.isEmpty() || !map.containsKey(c)) {
                map.put(c, r);
            }else {
                l = Math.min(r, map.get(c) + 1);
                map.put(c, r);
            }
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}