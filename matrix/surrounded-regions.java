class Solution {
    public void solve(char[][] board) {
        //think it in another way:
        //make all o in the grid besides the bounds to be x at last
        //use list to store the index of the bounds o
        //dfs to make boards another char
        //change o not on bounds x, 
        List<int[]> bounds = new ArrayList<>();
        for (int i = 0; i<board.length; i++) {
            bounds.add(new int[]{i, 0});
            bounds.add(new int[]{i, board[0].length - 1});
        }

        for (int i = 0; i<board[0].length; i++) {
            bounds.add(new int[]{0, i});
            bounds.add(new int[]{board.length - 1, i});
        }
        for (int[] single: bounds) {
            int i = single[0];
            int j = single[1];
            dfs(i, j, board);
        }

        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }
    public void dfs(int i, int j, char[][] board) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'E';
        if (i < board.length - 1) dfs(i + 1, j, board);
        if (j < board[0].length - 1) dfs(i, j + 1, board);
        if (i > 0) dfs(i - 1, j, board);
        if (j > 0) dfs(i, j - 1, board);
    }
}