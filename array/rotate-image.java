class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //starting from the first 0th row
        //keep the first num, make the last in the row to the first num
        //rotate it in clockwise
        for (int i = 0; i <n / 2; i++) {
            for (int j = 0; j <(n+1) / 2; j++) {
               //set as left top as[i][j]
               //right top [j][n - i - 1]
               //right buttom [n - i - 1][n - 1 - j];
               //left buttom [n - 1 - j][i]
               
               //set the left buttom, as the temp var
               int temp = matrix[n - 1 - j][i];
               matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1- j];
               matrix[n - i - 1][n - 1- j] = matrix[j][n - i - 1];
               matrix[j][n - i - 1] = matrix[i][j];
               matrix[i][j] = temp;
            }
        }
    }
}