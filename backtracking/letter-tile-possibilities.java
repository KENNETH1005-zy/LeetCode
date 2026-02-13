class Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        return dfs(chars, used);
    }

    public int dfs(char[] chars, boolean[] used) {
        int count = 0;

        for (int i = 0; i<chars.length; i++) {
            //if starting with used[i] used before, skip
            if (used[i]) continue;
            //if i >0 and same as i - 1, and [i - 1] is used before, skip
            //used mean starting with that char
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;

            count += 1 + dfs(chars, used);
            //undo
            used[i] = false;

        }
        return count;
    }
}