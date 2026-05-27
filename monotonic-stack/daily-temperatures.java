class Solution {
    public int[] dailyTemperatures(int[] ts) {
        int n = ts.length;
        int[] result = new int[n];
        //find the first one that is bigger on the right
        //use stack to store the t in desc order
        //if the new t is cooler add it to the stack
        //if the new t is wamer, while it is warmer than the top in
        //the stack, poll out from the stack, and implement the
        //top in result array as diff of indices

        //stack to store the indices
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<n; i++) {
            while (!stack.isEmpty() && ts[stack.peek()] < ts[i]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }
}