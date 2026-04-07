class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //int chlildren to record how many children are satisified
        int children = 0;
        //sort the g and s
        Arrays.sort(g);
        Arrays.sort(s);

        int cookie = 0;
        while (cookie < s.length && children < g.length) {
            if (g[children] <= s[cookie]) {
                cookie++;
                children++;
            }else {
                cookie++;
            }
        }
        return children;
    }
}