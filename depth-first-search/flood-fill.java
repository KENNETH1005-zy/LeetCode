class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //dfs to fill the image with the color
        int sourse = image[sr][sc];
        if (sourse != color) dfs(image, sr, sc, color, sourse);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int sourse) {
        //base case, out of bounds
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || 
            image[r][c] != sourse) {
                return;
        }
        image[r][c] = color;
        for (int[] dir: dirs) {
            int newR = dir[0] + r;
            int newC = dir[1] + c;
            dfs(image, newR, newC, color, sourse);
        }
    }
}