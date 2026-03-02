class Solution {
    //global set to store the current map, initialize everytime to find the valid set
    Map<Character, Integer> currentCount;
    public long wonderfulSubstrings(String word) {
        //it could be no odd number of char, or at most 1
        //cannot change the order of the word
        //store the valid string the the word
        //iterate the left pointer to the end of the word
        //second right pointer
        //if find the valid word add to the set
        //return the size of the set
        int left = 0;
        int right = 0;
        int n = word.length();
        List<String> result = new ArrayList<>();
        while (left < n) {
            String temp = word.substring(left, right + 1);
            this.currentCount = new HashMap<>();
            if (valid(temp)) {
                result.add(temp);
            }
            right += 1;
            if (right >= n) {
                left += 1;
                right = left;
            } 
        }
        return result.size();
    }
    //helper function to check if it is the valid set
    public boolean valid(String current) {
        for (char c: current.toCharArray()) {
            currentCount.put(c, currentCount.getOrDefault(c, 0) + 1);
        }
        //count of odd count of char
        int count = 0;
        for (int temp: currentCount.values()) {
            if (temp % 2 == 1) {
                count += 1;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count <= 1;
    }
}