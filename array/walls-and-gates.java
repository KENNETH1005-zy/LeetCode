class Solution {
    public void wallsAndGates(int[][] rooms) {
        //use bfs, to find the gates along the way
        //iterate the rooms, if there is a gate, record the shortest path
        //use a q to store the gates
        //while q is not empty
        //impelement the polled coordinate 
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        if (rooms.length == 0) return;
        int empty = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i< rooms.length; i++) {
            for (int j = 0; j< rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] gate = q.poll();
            
            int r = gate[0];
            int c = gate[1];

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                //out of bound
                if (newR < 0 || newR >= rooms.length || newC < 0 || newC >= rooms[1].length || 
                    rooms[newR][newC] != empty) {
                    continue;
                }
                rooms[newR][newC] = rooms[r][c] + 1;
                q.add(new int[]{newR, newC});
            }
        }

    }
}