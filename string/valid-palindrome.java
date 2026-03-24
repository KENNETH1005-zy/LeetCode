class Solution {
    public boolean isPalindrome(String s) {
        //two pointer,
        //find the left pointer until is letter or digit
        //also the right pointer
        //if the valid left and right char are not the same return false
        //return true
        int i = 0;
        int j = s.length()- 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}