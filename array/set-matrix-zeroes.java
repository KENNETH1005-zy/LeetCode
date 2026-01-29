class Solution {
    public void setZeroes(int[][] matrix) {
        //if first row or frst col has 0, make them all zero
        //mark the row and the col if find 0
        //after that implement 0 where row and col are marked
        //return the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        
        //list to store the row and col of 0 {row, col}
        //implement the list
        //implement the matrix using the list
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] single: list) {
            int row = single[0];
            int col = single[1];

            Arrays.fill(matrix[row], 0);

            for (int i = 0; i <m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}