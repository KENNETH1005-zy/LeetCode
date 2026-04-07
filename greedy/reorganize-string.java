class Pair {
    char c;
    int count;
    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
class Solution {
    public String reorganizeString(String s) {
        //sb to build the result
        //map to store each char's count
        //pq to the char, and the count, max heap
        //poll most frequent char from max heap,
        //if the char is the same as prev char in result
        //poll another one, if heap is empty return ""
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        //add each char count into map
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //store into pq
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            pq.offer(new Pair(c, count));
        }
        //construct the result string
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            char c = p.c;
            int count = p.count;
            //if sb is null or not as before, append it , count--
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                if (count - 1 > 0) {
                pq.offer(new Pair(c, count - 1));
            }
            }else {
                if (pq.isEmpty()) return "";
                Pair next = pq.poll();
                char nextCh = next.c;
                int nextCount = next.count;
                sb.append(nextCh);
                if (nextCount - 1 > 0) {
                    pq.offer(new Pair(nextCh, nextCount - 1));
                }
                //did not use c
                pq.offer(new Pair(c, count));
            }
           
        }
        return sb.toString();
    }
}