class Solution {
    public int countSubstrings(String s) {
        //make each s as the center, find how many palindrome
        int[] count = new int[]{0};
        for (int i = 0; i<s.length(); i++) {
            //for odd length
            expand(i, i, s, count);
            expand(i, i+1, s, count);
        }
        return count[0];
    }
    public void expand(int l, int r, String s, int[] count) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count[0]++;
            l--;
            r++;
        }
    }
}