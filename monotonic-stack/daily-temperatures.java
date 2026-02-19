class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //a stack to store temp that has not find warmer temp yet
        //if find the warmer temp, pop from the stack
        //record the day - day (in stack)
        int n = temperatures.length;
        int[] result = new int[n];
        //stack<int[]> {temp, day}
        Stack<int[]> stack = new Stack<>();
        Arrays.fill(result, 0);

        for (int i = 0; i<n; i++) {
            if (i == 0 || stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0] ) {
                int[] temp = stack.pop();
                int oldDay = temp[1];
                result[oldDay] = i - oldDay;
                
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}