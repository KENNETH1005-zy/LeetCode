class Solution {
    public boolean isPalindrome(String s) {
        //contvert all char to lower case
        String t = "";
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                t += Character.toLowerCase(c);
            }else if (Character.isDigit(c)) {
                t += c;
            }
        }
        int i = 0;
        int j = t.length() - 1;

        while (i <= j) {
            if (t.charAt(i) != t.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}