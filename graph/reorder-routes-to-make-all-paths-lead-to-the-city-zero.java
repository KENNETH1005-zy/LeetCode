class Solution {
    public int minReorder(int n, int[][] connections) {
        //make a adjacent list, one direction
        //make original direction as 1,
        //make reverse direction as 0. means current direc should be reverse to the original node
        Map <Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i<n; i++) map.put(i, new ArrayList<>());
        for (int[] connection: connections) {
            int i = connection[0];
            int j = connection[1];

            map.get(i).add(new int[]{j, 1});
            map.get(j).add(new int[]{i, 0});
        }
        boolean[] visited = new boolean[n];
        //all back to the city 0
        int result = dfs(0, map, visited);
        return result;
    }
    public int dfs(int current, Map<Integer, List<int[]>> map, boolean[] visited) {
        visited[current] = true;
        int result = 0;

        for (int[] neighbor: map.get(current)) {
            int i = neighbor[0];
            int reverse = neighbor[1];

            if (!visited[i]) {
                result += reverse;
                result += dfs(i, map, visited);
            }
        }
        return result;
    }
}