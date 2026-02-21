//use unionfind
class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i<n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public int find(int num){
        if (num != parent[num]) {
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public void union(int i, int j) {
        int iP = find(i), jP = find(j);
        if (iP == jP) {
            return;
        }else if (rank[iP] > rank[jP]) {
            parent[jP] = iP;
        }else if (rank[iP] < rank[jP]){
            parent[iP] = jP;
        }else {
            parent[jP] = iP;
            rank[iP]++;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int count = n;

        for (int i = 0; i< n; i++) {
            for (int j = i+1; j<n; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    count--;
                    uf.union(i, j);
                }
            }
        }
        return count;
    }
}