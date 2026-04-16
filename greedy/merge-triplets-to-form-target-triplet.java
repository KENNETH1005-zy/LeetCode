class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //compare the two int, maintain the bigger one
        int[] result = new int[3];
        for (int[] t: triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                result = new int[]{Math.max(result[0], t[0]), Math.max(result[1], t[1]), Math.max(result[2], t[2])};
            }
        }
        return Arrays.equals(result, target);
    }
}