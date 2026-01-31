class Solution {
    public String minRemoveToMakeValid(String s) {
        //always add '(' to the stack
        //if meets pair ')' with the peek in the stack, pop it
        //remaining are all valid, replace it with " "
        //trim all spaces
        Stack<int[]> stack = new Stack<>();//{ch, index}
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == '(' && c == ')') {
                stack.pop();
            }else if (c == '(' || c == ')') {
                stack.push(new int[]{c, i});
            }

        }
        while (!stack.isEmpty()) {
            sArray[stack.pop()[1]] = ' ';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            if (sArray[i] != ' ') {
                sb.append(sArray[i]);
            }
        }
        return sb.toString();
    }
}