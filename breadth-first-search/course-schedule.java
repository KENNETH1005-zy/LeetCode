class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[0] means course need to take, [1] is precourse
        //int[] indegree, means number of precoureses for each
        //use list to store thepreque num for each
        //use queue to add the available courses which is the courses with indegree is 0
        int[] indegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        
        //add new empty list for each course
        for (int i = 0; i< numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            int take = pre[0];
            int preclass = pre[1];
            //finish b then a, so construct like this
            list.get(preclass).add(take);
            indegree[take]++;
        }
        Queue<Integer> q = new LinkedList<>();
        //add courses that indegree is 0
        for (int i = 0; i<indegree.length; i++) {
            if (indegree[i]== 0) {
                q.offer(i);
            }
        }
        //use queue to add each pre
        //use visited 
        int visited = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            visited++;

            for (int neighbor: list.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return visited == numCourses;
    }
}