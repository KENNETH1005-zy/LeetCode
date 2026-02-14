class Solution {
    private static int minMoves;

    public static int minimumMoves(int[][] grid) {

        // Arrays to store coordinates of zeros (empty cells) and extras (cells with excess stones)
        List<int[]> zeros = new ArrayList<>();
        List<int[]> extras = new ArrayList<>();

		// Initialize minimum moves to a very large number
        minMoves = Integer.MAX_VALUE;
        
        // Calculate the total number of stones
        int totalStones = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                totalStones += cell;
            }
        }

		// Check if the total number of stones is exactly 9
        if (totalStones != 9) {
            return -1; // Return -1 if the total number of stones is not exactly 9
        }

        // Populate zeros and extras arrays
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (grid[x][y] == 0) {

					// Store the coordinates of empty cells
                    zeros.add(new int[]{x, y});
                } else if (grid[x][y] > 1) {

					// Store the coordinates and excess stones in cells with more than one stone
                    extras.add(new int[]{x, y, grid[x][y] - 1});
                }
            }
        }
        
        if (zeros.size() == 0) {
            return 0; // No moves needed if there are no empty cells
        }
        
        solve(zeros, extras, 0, 0);
        return minMoves;
    }
    private static void solve(List<int[]> zeros, List<int[]> extras, int i, int count) {
        
		// If all zeros have been processed
		if (i >= zeros.size()) {

			// Update the minimum moves if a better solution is found
            minMoves = Math.min(minMoves, count);
            return;
        }

		// Try to move stones from all extra cells to the current zero cell
        for (int k = 0; k < extras.size(); k++) {

			// Check if there are stones to move
            if (extras.get(k)[2] != 0) {

				// Move one stone from the extra cell to the zero cell
                extras.get(k)[2]--;

				// Recursively solve for the next zero cell
                solve(zeros, extras, i + 1, Math.abs(extras.get(k)[0] - zeros.get(i)[0]) + Math.abs(extras.get(k)[1] - zeros.get(i)[1]) + count);
                
				// Backtrack: undo the move
				extras.get(k)[2]++;
            }
        }
    }
}