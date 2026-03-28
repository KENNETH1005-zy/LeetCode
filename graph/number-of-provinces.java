//use UnionFind class to connect the same province
class UnionFind{
    //an array to record parent of the element
    //rank for each element
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public void union(int i, int j) {
        //find each parent
        //compare the rank of their parents
        //union them
        int ip = find(i);
        int jp = find(j);

        if (ip == jp) {
            return;
        }else if (rank[ip] > rank[jp]) {
            parent[jp] = ip;
        }else if (rank[jp] > rank[ip]) {
            parent[ip] = jp;
        }else {
            parent[jp] = ip;
            rank[ip]++;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return parent[i];
        }
        return find(parent[i]);
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