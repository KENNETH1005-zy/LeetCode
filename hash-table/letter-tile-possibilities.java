class Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        return dfs(chars, used);
    }

    private int dfs(char[] chars, boolean[] used) {
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;

            // Skip duplicates: if previous same char is not used, skip
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            count += 1 + dfs(chars, used); // +1 for current string, +dfs for longer ones
            used[i] = false;
        }

        return count;
    }
}