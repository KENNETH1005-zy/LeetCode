//helper function
class UnionFind{
    //map to record the parent and the rank
    private Map<Integer, Integer> parents;
    private Map<Integer, Integer> ranks;
    public UnionFind(){
        parents = new HashMap<>();
        ranks = new HashMap<>();
    }
    //find function to find the root of a single coordinate
    public int find(int num) {
        if (parents.get(num) != num) {
            parents.put(num, find(parents.get(num)));
        }
        return parents.get(num);
    }
    //union the row and col to one
    public void union(int x, int y) {
        //offset to avoid the crush
        parents.putIfAbsent(x, x);
        parents.putIfAbsent(y, y);

        ranks.putIfAbsent(x, 0);
        ranks.putIfAbsent(y, 0);

        if (ranks.get(x) > ranks.get(y)) {
            parents.put(find(y), find(x));
        }else if (ranks.get(x) < ranks.get(y)) {
            parents.put(find(x), find(y));
        }else {
            parents.put(find(x), find(y));
            ranks.put(find(y), ranks.get(find(y)) + 1);
        }
    }
    public Map<Integer, Integer> getParents(){
        return parents;
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int offset = 10000;
        UnionFind uf = new UnionFind();
        for (int[] stone: stones) {
            int x = stone[0];
            int y = stone[1] + offset;
            uf.union(x, y);
        }

        Set<Integer> groups = new HashSet<>();
        Map<Integer, Integer> parents = uf.getParents();

        for (Map.Entry<Integer, Integer> entry: parents.entrySet()) {
            int key = entry.getKey();
            groups.add(uf.find(key));
        }
        return stones.length - groups.size();
    }
}