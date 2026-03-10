class Solution {
    public int appendCharacters(String s, String t) {
        //a pointer at s, and another pointer in t
        //iterate in s, if found, move the pointer in t
        //return length - pointer in t
        int p1 = 0;
        int p2 = 0;

        while (p2 < t.length() && p1 < s.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p2++;
            }
            p1++;
        }
        return t.length() - p2;
    }
}