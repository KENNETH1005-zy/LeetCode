class Solution {
    private int max = 0;
    public int maxUniqueSplit(String s) {
        //dfs to find the max length
        dfs(0, s, new HashSet<>());
        return max;
    }
    public void dfs(int start, String s, Set<String> set) {
        //base case, reach the end of s
        if (start == s.length()) {
            max = Math.max(max,set.size());
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String temp = s.substring(start, end);
            if (!set.contains(temp)) {
                set.add(temp);
                dfs(end, s, set);
                //undo
                set.remove(temp);
            }
        }
    }
}