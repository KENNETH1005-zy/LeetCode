class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //use adj list to store the relationship
        //if find a circle, return -1
        //iterate from the first course, update the maxlength
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] relation: relations) {
            adj.get(relation[0]).add(relation[1]);
        }
        int maxLength = 1;
        int[] visited = new int[n + 1];
        for (int i = 1; i<=n; i++) {
            int length = dfs(i, adj, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    public int dfs(int node, List<List<Integer>> adj, int[] visited ) {
        //base case
        if (visited[node] != 0) {
            //return the longest path for that
            //if visited
            return visited[node];
        }else {
            visited[node] = -1;
            //mark as visiting
        }
        int maxLength = 1;
        //visited its after courses
        for (int temp: adj.get(node)) {
            int length = dfs(temp, adj, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length + 1, maxLength);
        }
        visited[node] = maxLength;
        return maxLength;
    }
}