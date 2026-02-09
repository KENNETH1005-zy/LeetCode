class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];

        //get the '1' num on each row
        //pq for min, sort by num of '1', if 1 are the same
        //use the row index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i<mat.length; i++) {
            int soldiers = get(mat[i]);
            pq.add(new int[]{soldiers, i});
        }
        int index = 0;
        while (!pq.isEmpty() && index < k) {
            result[index] = pq.poll()[1];
            index++;
        }
        return result;
    }
    //helper function to get num of 1
    public int get(int[] row) {
        int left = 0;
        int right = row.length;//this is the bound not index, to handle the full 1 situation

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == 1) {
                //find others
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        //return the num of 1
        return left;
    }
}