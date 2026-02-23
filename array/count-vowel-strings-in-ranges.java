class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        //set to store the vowels
        int[] result = new int[queries.length];
        //prefix sum array to store the how many valid set so far in the array
        //int query,  result[i] = prefix[right + 1] - prefix[left]
        //return the result
        int[] prefix = new int[words.length + 1];

        for (int i = 0; i<words.length; i++) {
            //if the current word is valid add 1
            prefix[i + 1] = prefix[i] + (isValid(words[i]) ? 1 : 0);
        }

        for (int i = 0; i<queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            result[i] = prefix[right + 1] - prefix[left];
        }
        return result;
    }
    //function to determine if this is the valid set
    public boolean isValid(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
    }
}