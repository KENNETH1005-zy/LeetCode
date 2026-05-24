class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        //add the value at the start
        //and if the current end index is not the last one
        //minus value at there, 
        //after that, using a total sum, to add the
        //prev minus num recovered and the nums in between has the num to add
        for (int i = 0; i< updates.length; i++) {
            int value = updates[i][2];
            int start = updates[i][0];
            int end = updates[i][1];

            result[start] += value;
            if (end < length - 1) result[end + 1] -= value;
        }

        int sum = 0;
        for (int i = 0; i<length; i++) {
            sum += result[i];
            result[i] = sum;
            
        }
        return result;
    }
}