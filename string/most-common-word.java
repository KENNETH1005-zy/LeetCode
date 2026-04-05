class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //store the words and count in a map
        //a set to store the banned words
        //iterate through in the para
        //global result to return
        //sb to store the current word
        //if char is letter, append it to the word sb
        //if not the last char in the paragraph and continue to the next char
        //if it is the last in the paragraph, or it is not the letter
        //if not banned store it in the map, increase the count
        //if the count is more than before, update the result
        //return result

        Map<String, Integer> map = new HashMap<>();
        Set<String> ban = new HashSet<>();
        int maxCount = 0;
        for (String s: banned) {
            ban.add(s);
        }
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< paragraph.length(); i++) {
            //if the current is letter
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                if (i != paragraph.length() - 1) {
                    continue;
                }
            }
            //if it is the last in the paragraph, or it is not the letter
            if (sb.length() > 0) {
                String temp = sb.toString();
                if (!ban.contains(temp)) {
                    int newCount = map.getOrDefault(temp, 0) + 1;
                    map.put(temp, newCount);
                    if (newCount > maxCount) {
                        result = temp;
                        maxCount = newCount;
                    }
                }
                //reset the sb
                sb = new StringBuilder();
            }
        }
        return result;
    }
}