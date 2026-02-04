class TicTacToe {
    //a map to store the moves
    //for every row make a list of size n
    //if player one moves, add 1, on that postion
    //if any row's sun is n, return the current player
    Map <Integer, Integer> rows;
    Map<Integer, Integer> cols;
    int diagonal;//if the row - col is 0
    int antiDiagonal;//if row + col is n - 1
    int n;
    public TicTacToe(int n) {
        rows = new HashMap<>();
        cols = new HashMap<>();
        for (int i = 0; i<n; i++) {
            rows.put(i, 0);
            cols.put(i, 0);
        }
        diagonal = 0;
        antiDiagonal = 0;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int current = player == 1 ? 1 : -1;
        if (row - col == 0) {
            diagonal += current;
        }
        if (row + col == n - 1) {
            antiDiagonal += current;
        }
        rows.put(row, rows.get(row) + current);
        cols.put(col, cols.get(col) + current);

        if (Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n || Math.abs(rows.get(row)) == n ||
            Math.abs(cols.get(col)) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */