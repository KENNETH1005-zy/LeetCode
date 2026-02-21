class Solution {
    public int findCircleNum(int[][] isConnected) {
        //1 means connected
        //0 means not connected
        int n = isConnected.length;
        int result = n;
        //using map to show how many cities are connected
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        int count = 0;
        for (int value: map.values()) {
            count = Math.max(count, value);
        }
        return result - count;
    }
}