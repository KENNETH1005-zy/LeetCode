class Solution {
    public boolean checkValidString(String s) {
        //use a stack to store (
        //every time find a ), pop a ( from the stack
        //* is a wild card, use a new stack to store the wild card
        //if current ) , and two stacks are both empty, return false
        Stack <Character> left = new Stack<>();
        Stack <Character> wild = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(') {
                left.push('(');
            }else if (c == '*') {
                wild.push('*');
            }else {
                if (!left.isEmpty()) {
                    left.pop();
                }else if (!wild.isEmpty()) {
                    wild.pop();
                }else if (left.isEmpty() && wild.isEmpty()) {
                    return false;
                }
            }
        }
        //if there is other ( still left, return false
        //find if the wild cards match the left
        while (!left.isEmpty() && !wild.isEmpty()) {
            left.pop();
            wild.pop();
        }
        return left.isEmpty();
    }
}