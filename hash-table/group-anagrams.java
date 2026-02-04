class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //calculate the count of each char in a str
        //and store it in  map
        //each time find a new one with the same count, add to the map
        //return the result
        //make a count array for each string
        //if contains in the map, add to it
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str: strs) {
            Arrays.fill(count, 0);
            for (char c: str.toCharArray()) {
                int one = c - 'a';
                count[one]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int single: count) {
                sb.append('#');
                sb.append('a' + single);
            }
            String temp = sb.toString();
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}