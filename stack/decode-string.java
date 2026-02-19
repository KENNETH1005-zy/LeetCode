class Solution {
    public String decodeString(String s) {
        //stack for count
        //stack for string
        //stringbuilder for the current string
        Stack<Integer> count = new Stack<>();
        Stack<String> word = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;

        //iterate in the s
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = 10 * k + c - '0';
            }else if (c == '[') {
                //add to stacks
                count.push(k);
                word.push(sb.toString());

                k = 0;
                sb.setLength(0);
            }else if (c == ']') {
                StringBuilder temp = new StringBuilder(word.pop());
                int num = count.pop();
                for (int i = 0; i<num; i++) {
                    temp.append(sb);
                }
                sb = temp;
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}