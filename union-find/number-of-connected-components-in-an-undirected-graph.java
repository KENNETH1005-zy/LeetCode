//union find to find the number of the sets
class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i<n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public int find(int num) {
        if (parent[num] == num) {
            return num;
        }
        return find(parent[num]);
    }

    public void union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if (pA == pB) {
            return;
        }else if (rank[pA] > rank[pB]) {
            parent[pB] = pA;
        }else if (rank[pB] < rank[pA]) {
            parent[pA] = pB;
        }else {
            parent[pB] = pA;
            pA++;
        }
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;

        UnionFind uf = new UnionFind(n);

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            if (uf.find(a) != uf.find(b)) {
                count--;
            }
            uf.union(a, b);
        }
        return count;
    }
}