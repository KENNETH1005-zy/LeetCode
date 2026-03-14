class Solution {
    public String longestPalindrome(String s) {
        //use the expand from center approach
        int[] result = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            if (oddLength > result[1] - result[1] + 1) {
                int dist = oddLength / 2;
                result[0] = i - dist;
                result[1] = i + dist;
            }

            int evenLength = expand(i, i+1, s);
            if (evenLength > result[1] - result[0] + 1) {
                int dist = evenLength / 2 - 1;
                result[0] = i - dist;
                result[1] = i + 1 + dist;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
    //helper function for expand
    public int expand(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        //the reason is the current length is two more than the valid length
        return j - i - 1;
    }
}