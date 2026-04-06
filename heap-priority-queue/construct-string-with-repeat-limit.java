class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        //use map to record the char, freq
        //use pq to store the lex largest char
        //for each char, use it as much as it can, then push them back to the heap
        //if the count is still left
        //use sb to build the result
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> charFreq = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        //record count
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        //add all unique char in pq
        for (char c: charFreq.keySet()) {
            pq.offer(c);
        }
        //while the pq is not empty
        //poll out the highest lex 
        //use max time as it can
        //put it back
        //update the charFreq
        while (!pq.isEmpty()) {
            char c = pq.poll();
            
            int use = Math.min(charFreq.get(c), repeatLimit);
            for (int i = 0; i<use; i++) {
                sb.append(c);
            }
            //update in the map
            charFreq.put(c, charFreq.get(c) - use);
            
            //if exceed the time it can use
            //find the next one, decrease one as a blocker
            if (charFreq.get(c) > 0 && !pq.isEmpty()) {
                char next = pq.poll();
                sb.append(next);
                charFreq.put(next, charFreq.get(next) - 1);
                if (charFreq.get(next) > 0) {
                    pq.offer(next);
                }
                pq.offer(c);
            }
            
        }
        return sb.toString();
    }
}