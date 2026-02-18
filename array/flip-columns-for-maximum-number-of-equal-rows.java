class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //mark and store every 1 or 0 in a specific num
        //mark the first num in each row as 0, and if not the same, mark it 1 in a row
        //find the max rows with the same pattern
        //if every rows pattern are not the same, return 1
        //otherwise return max count
        //return those count of rows

        //store the pattern from int to String to a hash
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i< matrix.length; i++) {
            int first = matrix[i][0];
            String temp = "0";
            for (int j = 1; j<matrix[0].length; j++) {
                if (matrix[i][j] == first) {
                    temp += "0";
                }else {
                    temp += "1";
                }
            }

            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int result = 0;
        for (int count: map.values()) {
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}