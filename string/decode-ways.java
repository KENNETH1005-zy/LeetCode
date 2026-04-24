class Solution {
    //map to record how many solution the current index have
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        //recursive
        return dfs(0, s);
    }
    public int dfs(int index, String s) {
        //base case
        int result = 0;
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        //use the size of 1, find the solutions of the rest
        result += dfs(index + 1, s);
        //find if the size of two is valid
        //if valid add the solution
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            result += dfs(index + 2, s);
        }
        return result;
    }
}