class Solution {
    //a -> b -> c, now a, b,c are we are searching
    //if mean any of it again
    //return false
    //seen it before, means this one is valid, search for next
    boolean[] inStack;
    boolean[] seen;
    List<List<Integer>> pres;
    public boolean canFinish(int numCourses, int[][] press) {
        //if there is circle return false
        //list to store the precourses of a course
        //course -> pres
        pres = new ArrayList<>();
        //use an array to store the size of pre courses of a course
        //if no pre, means no pres to take
        //{second, first}
        //second inDegree is true
        //if pre is one, means there is circle
        inStack = new boolean[numCourses];
        seen = new boolean[numCourses];
        //implement the pres
        for (int i = 0; i<numCourses; i++) {
            pres.add(new ArrayList<>());
        }
        for (int[] pre: press) {
            int second = pre[0];
            int first = pre[1];
            pres.get(second).add(first);
        }
        for (int i = 0; i<numCourses; i++) {
            //if find circle return false
            if (dfs(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int i) {
        if (inStack[i]) {
            return true;
        }
        if (seen[i]) {
            return false;
        }
        inStack[i] = true;
        seen[i] = true;

        //continue to validate the neighbors
        for (int neighbor: pres.get(i)) {
            if (dfs(neighbor)) {
                return true;
            }
        }
        //remove from the stack
        inStack[i] = false;
        return false;
    }
}