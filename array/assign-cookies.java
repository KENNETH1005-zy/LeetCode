class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int index = 0;
        int content = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (index < s.length && content < g.length) {
            if (s[index] >= g[content]) {
                content++;
            }
            index++;
        }
        return content;
    }
}