class Solution {

    public String longestPalindrome(String s) {
        //using sliding window
        //once find a palindrome, recording then length
        //for every right pointer, left pointer from beginning, find palindrome
        //return the longest

        int[] result = new int[]{0, 0};
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                String temp = s.substring(left, right+1);
                if (valid(temp) && max < right - left + 1) {
                    result[0] = left;
                    result[1] = right;
                    max = right - left + 1;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);

    }
    //helper function to check if it is palindrome
    public boolean valid(String word) {
        int l = 0;
        int r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}