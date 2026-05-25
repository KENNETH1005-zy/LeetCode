class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n <2) {
            for (int i = 0; i<n; i++) {
                result.add(i);
                return result;
            }
        }
        
        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            neighbors.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            neighbors.get(from).add(to);
            neighbors.get(to).add(from);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i<neighbors.size(); i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int leftNodes = n;
        while (leftNodes > 2) {
            leftNodes -= leaves.size();
            //construct the new leave list
            List<Integer> newLeaves = new ArrayList<>();
            //for every leaf
            for (Integer leaf: leaves) {
                Integer neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}