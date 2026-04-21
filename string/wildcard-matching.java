class Solution {
    public boolean isMatch(String s, String p) {
        // ? can be the single wild card
        // * can be any wild card
        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {
            char sch = s.charAt(i);
            char pch = p.charAt(j);
            if (sch == pch) {
                i++;
                j++;
                continue;
            }else {
                if (pch == '*') {
                    i++;
                    continue;
                }else if (pch == '?') {
                    i++;
                    j++;
                    continue;
                }else {
                    return false;
                }
            }
        }
        if (i < s.length()) {
            if (p.charAt(p.length() - 1) != '*') {
                return false;
            }
        }
        return true;
    }
}