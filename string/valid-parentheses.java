class Solution {
    public boolean isValid(String s) {
        //use stack to store the left backet
        //if find the same type of backet pop it
        //if diffrent type return false
        //if stack is not null after all, return false
        Stack<Integer> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(1);
            }else if (c == '{') {
                stack.push(2);
            }else if (c == '[') {
                stack.push(3);
            }

            int num  = 0;
            if (c == ')') {
                num = 1;
            }else if (c == '}'){
                num = 2;
            }else if (c == ']') {
                num = 3;
            }

            if (num > 0 && !stack.isEmpty()) {
                int check = stack.peek();
                if (check == num) {
                    stack.pop();
                }else {
                    return false;
                }
            }else if (num >0 && stack.isEmpty()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}