class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        //b -> a
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];
        //list to store the courses can take for each class
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : pre) {
            int course = p[0];      // course that needs a prereq
            int prereq = p[1];      // the course that must be taken first
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        //if dont need precourses, add to a queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i< indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            result[index++] = c;

            for (int course: adj.get(c)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.offer(course);
                }
            }
        }

        if (index != numCourses) {
            return new int[]{};
        }

        return result;
    }
}