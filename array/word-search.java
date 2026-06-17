class Solution {
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        //if if the word in the board
        //dfs to find the word
        //index in word to match
        //starting from the first
        //dfs find in 4 dirs
        //return true if index is the length of the word
        //dont search back use a memory boolean[][]
        this.board = board;
        this.word = word;

        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = dfs(i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int row, int col, int index) {
        if (index== word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean up = dfs(row - 1, col, index + 1);
        boolean down = dfs(row + 1, col, index + 1);
        boolean left = dfs(row, col - 1, index + 1);
        boolean right = dfs(row, col + 1, index + 1);
        board[row][col] = temp;
        return up || down || left || right;
    }
}