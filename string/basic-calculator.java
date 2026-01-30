class Solution {
    public int calculate(String s) {
        //using Stack to store the num and "("
        //sign to record the status of positive or negative
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;
        int num = 0 ;//the num to be manipulated, in the smallest portion
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }else if (c == '+' || c == '-') {
                sum += num * sign;
                if (c == '+') {
                    sign = 1;
                }else{
                    sign = -1;
                }
                num = 0;

            }else if (c == '(') {
                //store the prev result and signto stack, initialize the sum
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }else if (c == ')') {
                sum += num * sign;

                int popedsign = stack.pop();
                sum *= popedsign;

                int popedresult = stack.pop();
                sum += popedresult;
    
                num = 0;
                sign = 1;
            }else {
                continue;
            }
        }
        return sum + sign * num;
    }
}