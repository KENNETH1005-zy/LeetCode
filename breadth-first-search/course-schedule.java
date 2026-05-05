class Solution {
    public boolean canFinish(int numCourses, int[][] ps) {
        //must take b first then the a
        //create a list for storing b for an a
        //return true if not circle detected
        //boolean array for inStack and seen
        //for each numCourse, dfs to find if circle
        //backtracking
        List<List<Integer>> pres = new ArrayList<>();
        for (int i = 0; i<numCourses; i++) {
            pres.add(new ArrayList<>());
        }

        for (int[] p: ps) {
            pres.get(p[0]).add(p[1]);
        }
        //in stack means there is a circle
        boolean[] inStack = new boolean[numCourses];
        boolean[] seen = new boolean[numCourses];
        for (int i = 0; i<numCourses; i++) {
            if (dfs(i, pres, inStack, seen)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, List<List<Integer>> pres, boolean[] inStack, boolean[] seen) {
        //if in stack
        if (inStack[i]) {
            return true;
        }
        //seen it before, break the dfs to find others
        if (seen[i]) {
            return false;
        }
        inStack[i] = true;
        seen[i] = true;
        //for the adj
        for (int neighbor: pres.get(i)) {
            if (dfs(neighbor, pres, inStack, seen)) {
                return true;
            }
        }
        //backtracking remove from the stack
        inStack[i] = false;
        return false;
    }
}