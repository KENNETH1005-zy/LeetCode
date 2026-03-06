class Solution {
    public boolean canPermutePalindrome(String s) {
        //store the char and the count in the map
        //if the counts are all even and the num of odd is not 0
        //if the only count of odd is 1, return ture
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int value: map.values()) {
            if (value % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}