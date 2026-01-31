class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        //map each node, on both way
        //find the intersection in the adjacency list
        //every one means there is a cycle, because we can use this as the intermedia, to make the cycle
        Map <Integer, Set<Integer>> map = new HashMap<>();
        int result = 0;
        for (int [] corridor: corridors) {
            int i = corridor[0];
            int j = corridor[1];
            map.putIfAbsent(i, new HashSet<>());
            map.putIfAbsent(j, new HashSet<>());

            map.get(i).add(j);
            map.get(j).add(i);
            result += find(map.get(i), map.get(j));
        }
        return result;
    }
    //helper fuction to calculate the intersection
    public int find(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (int single: set1) {
            if (set2.contains(single)) {
                count++;
            }
        }
        return count;
    }
}