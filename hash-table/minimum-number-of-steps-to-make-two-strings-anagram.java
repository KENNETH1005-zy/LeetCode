class Solution {
    public int minSteps(String s, String t) {
        //using the hash table to store the ch  and the count that occurrs in String s
        //then iterate in string t
        //if the char in t is contains in hash, decrease the count
        //add up all the count in hash
        Map <Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c: t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
                count++;
            }
        }
        return t.length() - count;
    }
}