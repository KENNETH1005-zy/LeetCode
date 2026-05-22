class Solution {
    public boolean canTransform(String start, String result) {
        //L can only move left, and opposite as R
        //record the relative order of L and R
        //if the num of L or the number of R are not the same
        //or the relative order is not correct return false
        //otherwise return true
        int countL = 0;
        int countR = 0;
        //a queue to store the r and l
        Deque<Character> dq = new LinkedList<>();
        for (int i = 0; i<start.length(); i++) {
            char s = start.charAt(i);

            if (s == 'L' || s == 'R') {
                dq.addLast(s);
                if (s == 'L') countL++;
                if (s == 'R') countR++;
            }
        }
        for (char c: result.toCharArray()) {
            if (c == 'L' || c == 'R') {
                if (dq.isEmpty() || dq.peekFirst() != c) return false;
                char polled = dq.pollFirst();
                
                if (polled == 'L') {
                    countL--;
                }else if (polled == 'R') {
                    countR--;
                }
            }
        }
        if (countL != 0 || countR != 0) return false;
        return true;
    }
}