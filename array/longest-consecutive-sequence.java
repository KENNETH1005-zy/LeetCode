//create a union find class
class UnionFind {
    //map for parent
    //map for size
    //maxLength
    Map<Integer, Integer> parents;
    Map<Integer, Integer> sizes;
    int maxLength;

    public UnionFind(int[] nums){
        parents = new HashMap<>();
        sizes = new HashMap<>();
        maxLength = 1;
        for (int num: nums) {
            parents.put(num, num);
            sizes.put(num, 1);
        }
    }

    public int find(int num) {
        if (num != parents.get(num)) {
            parents.put(num, find(parents.get(num)));
        }
        return parents.get(num);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            int sizeX = sizes.get(rootX);
            int sizeY = sizes.get(rootY);
            //make sure the size of x is bigger or equal to y
            if (sizeX < sizeY) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parents.put(rootY, rootX);
            sizes.put(rootX, sizeX + sizeY);
            maxLength = Math.max(maxLength, sizeX + sizeY);
        }
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        UnionFind uf = new UnionFind(nums);

        for (int num: nums) {
            if (uf.parents.containsKey(num + 1)) {
                uf.union(num, num + 1);
            }
        }
        return uf.maxLength;
    }
}