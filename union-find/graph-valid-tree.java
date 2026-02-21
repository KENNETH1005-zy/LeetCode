class Solution {
    public boolean validTree(int n, int[][] edges) {
        //use map to store the edge
        //if the values of a and values of b has interjection
        //return false
        //after all return true
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(a).add(b);
            map.get(b).add(a);

            for (int single: map.get(a)) {
                if (map.get(b).contains(single)) {
                    return false;
                }
            }
        }
        return true;

    }
}