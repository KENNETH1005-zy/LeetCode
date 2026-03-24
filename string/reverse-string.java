class Solution {
    public void reverseString(char[] s) {
        //change the char at front and the end
        //return the original s
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}