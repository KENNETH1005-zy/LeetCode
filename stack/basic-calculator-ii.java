class Solution {
    public int calculate(String s) {
        //use stack to store the num that about to manipulate
        //use char operator to record the last operator
        //use currentNum to store the current num
        //iterate through the s
        //add the rest in the stack to the result
        //return result;

        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int current = 0;

        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                //in case it has multiple digits
                current = current * 10 + c - '0';
            }
            //if c is not digit and not space, or it is the last one in s
            if (!Character.isDigit(c) && !Character.isWhitespace(c) ||
                i == s.length() - 1) {
                
                if (operator == '+') {
                    stack.push(current);
                }else if (operator == '-') {
                    stack.push(-current);
                }else if (operator == '*') {
                    stack.push(stack.pop() * current);
                }else if (operator == '/') {
                    stack.push(stack.pop() / current);
                }
                //reset the operator and the current num
                operator = c;
                current = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}