class Solution {
    public void gameOfLife(int[][] board) {
        //dont change the original status, just record, as candidate
        //1, <= 1 1 neighbors, become 0
        //1, 2 <= neighbors 1 <= 3, still 1
        //1, neighbors more than 3, dies
        //0, with 3 neighbors, becomes 1
        int[] dirs = {-1, 0, 1};
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                int lives = 0;
                int num = board[i][j];

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (!(dirs[r] == 0 && dirs[c] == 0)) {
                            //cannot be itself
                            int newR = i + dirs[r];
                            int newC = j + dirs[c];
                            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length
                                && Math.abs(board[newR][newC]) == 1) {
                                lives += 1;
                            }
                        }
                    }
                }
                
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                }else {
                    board[i][j] = 0;
                }
            }
        }
    }
}