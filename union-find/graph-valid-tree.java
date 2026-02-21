//class UnionFind
class UnionFind {
    private int[] root;
    //Constructor
    public UnionFind(int n) {
        root = new int[n];
        for (int i = 0; i<n; i++) {
            root[i] = i;
        }
    }

    public int find(int num) {
        if (root[num] == num) {
            return root[num];
        }
        return find(root[num]);
    }

    //union function to find if the current two node belongs to the same parent
    public boolean union(int A, int B) {
        int parentA = find(A);
        int parentB = find(B);

        if (parentA == parentB) {
            return false;
        }
        //else just make root of B is the parent of A
        root[find(A)] = find(B);
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);

        for (int[] edge: edges) {
            int A = edge[0];
            int B = edge[1];

            if (!uf.union(A, B)) {
                return false;
            }
        }
        return true;
    }
}