class Solution {
    public boolean canTransform(String start, String result) {
        //if the numbers of X are not the same, return false
        //two pointer
        //skip all the x
        //if reach x at the same time return true
        //if the char are not the same return false
        //if char is r and the i > j, means cannot go right return false
        //if char is l and i < j, return false
        //return true at last
        int n = start.length();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n || j < n) {
            if (i < n && start.charAt(i) == 'X') {
                count++;
            }
            if (j <n && result.charAt(j) == 'X') {
                count--;
            }
            i++;
            j++;
        }
        if (count != 0) return false;
        
        i = 0;
        j = 0;
        while (i < n || j < n) {
            while (i <n && start.charAt(i) == 'X') {
                i++;
            }

            while (j <n && result.charAt(j) == 'X') {
                j++;
            }
            if (i == n && j == n) return true;

            if (start.charAt(i) != result.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}