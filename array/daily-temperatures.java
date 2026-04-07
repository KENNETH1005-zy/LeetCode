class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //use stack to store the temp and the day
        //iterate through the temp array
        //if new warmer days is found, pop out from the stack, until empty
        //update the result array
        //and push the new one
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i< temperatures.length; i++) {
            //if empty
            if (stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
                continue;
            }
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] temp = stack.pop();
                int oldDay = temp[1];
                result[oldDay] = i - oldDay;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        //if there are left in stack
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            int day = temp[1];
            result[day] = 0;
        }
        return result;
    }
}