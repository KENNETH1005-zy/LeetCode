class Solution {
    public boolean checkValidString(String s) {
        //use a stack to store (
        //every time find a ), pop a ( from the stack
        //* is a wild card, use a new stack to store the wild card
        //if current ) , and two stacks are both empty, return false
        Stack <Integer> left = new Stack<>();
        Stack <Integer> wild = new Stack<>();

        for (int i = 0; i<s.length(); i++) {
            int c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            }else if (c == '*') {
                wild.push(i);
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
        //and ( cannot appears after *
        while (!left.isEmpty() && !wild.isEmpty()) {
            if (left.pop() > wild.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }
}