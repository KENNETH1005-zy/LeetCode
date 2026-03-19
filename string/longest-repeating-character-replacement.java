class Solution {
    public int characterReplacement(String s, int k) {
        //store the freq in the int[] for each letter
        //starting from 0th, in s, find longest
        //boolean is Valid, if length - max count >=k
        //if not shrink the window from the left, decrease the count
        //return the longest
        int[] freq = new int[26];
        int l = 0;
        int longest = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            freq[index] += 1;
            
            max = Math.max(max, freq[index]);
            boolean valid = (r + 1 - l - max <= k);
            if (!valid) {
                int out = s.charAt(l) - 'A';
                freq[out] -= 1;
                l += 1;
            }
            longest = r + 1 - l;
        }
        return longest;
    }
}