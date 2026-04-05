class MinStack {
    //use two stacks
    //one for storing the total nums
    //another one for only the nums that is smaller than peek in stack
    //store it as the {num, count}
    Stack<Integer> stack;
    Stack<int[]> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek()[0] > val) {
            minStack.push(new int[]{val, 1});
        }
        else if (minStack.peek()[0] == val) {
            minStack.peek()[1]++;
        }
    }
    
    public void pop() {
        //if the pop one is not in the minStack, just pop it from stack
        if (!stack.peek().equals(minStack.peek()[0])) {
            stack.pop();
        }else{
            stack.pop();
            minStack.peek()[1]--;
            if (minStack.peek()[1] == 0) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */