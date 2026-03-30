class Solution {
    public int minimumEffortPath(int[][] heights) {
        //use binary search to find if we can find a abs diff under K
        int left = 0;
        int right = 1000000;
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //if can reach the end, find a smaller one
            if (canUnder(mid, heights)) {
                result = Math.min(result, mid);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return result;
    }
    //helepr function to detect if can reach the end
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean canUnder(int mid, int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return canReach(0, 0, heights, visited, rows, cols, mid);
    }
    public boolean canReach(int x, int y, int[][] heights,
                               boolean[][] visited, int rows, int cols, int mid) {
        //if reach end
        if (x == rows - 1 && y == cols - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] dir: directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValidCell(newX, newY, rows, cols) && !visited[newX][newY]) {
                int currentDiff = Math.abs(heights[newX][newY] - heights[x][y]);
                if (currentDiff <= mid) {
                    if (canReach(newX, newY, heights, visited, rows, cols, mid)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //helper function can reach the end
    //helper function to detect if current cell is in bound
    public boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}