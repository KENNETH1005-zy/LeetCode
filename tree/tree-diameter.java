class Solution {
    public int treeDiameter(int[][] edges) {
        //make a map, in double way
        //record the longest the path for a single node
        //combine two longest path
        Map <Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            int i = edge[0];
            int j = edge[1];
            map.putIfAbsent(i, new HashSet<>());
            map.get(i).add(j);
            map.putIfAbsent(i, new HashSet<>());
            map.get(i).add(j);
        }
        //store the result in int[], pass by reference
        int[] diameter = new int[]{0};
        boolean[] visited = new boolean[edges.length + 1];
        dfs(0, edges, visited, diameter, map);
        return diameter[0];
    }
    //find the top two longest path, and add them together
    public int dfs(int node, int[][] edges, boolean[] visited, int[] diameter, Map <Integer, Set<Integer>> map) {
        visited[node] = true;
        int top1 = 0, top2 = 0;

        for (int neighbor: map.getOrDefault(node, new HashSet<>())) {
            if (!visited[neighbor]) {
                int dict = 1 + dfs(neighbor, edges, visited, diameter, map);

                if (dict > top1) {
                    top2 = top1;
                    top1 = dict;
                }else if (dict > top2) {
                    top2 = dict;
                }
            }
        }
        diameter[0] = Math.max(diameter[0], top1 + top2);
        return top1;
    }
}