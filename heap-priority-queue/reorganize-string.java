class Solution {
    public String reorganizeString(String s) {
        //use first most and second most freq char
        //maxHeap to strore the char and the count, sorting on count
        //if the sb is null or the first one poll out is not the same
        //as the prev one, add it to the string
        //if it is the same add it to the maxheap
        //find the next most freq
        //if maxHeap is null, at this time return ""
        //if not add it to the sb
        //return if maxHeap is null
        //else return ""

        //use an int[] to store the count for each
        int[] counts = new int[26];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        //for the counts that is more than 1
        for (int i = 0; i<counts.length; i++) {
            if (counts[i] > 0) {
                maxHeap.add(new int[]{ i+ 'a', counts[i]});
            }
        }
        //implement the sb, using the maxHeap
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char) first[0]);
                if (--first[1] >0) {
                    maxHeap.add(first);
                }
            }else {
                //the same 
                if (maxHeap.isEmpty()) return "";
                int[] second = maxHeap.poll();

                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    maxHeap.add(second);
                }
                maxHeap.add(first);
            }
        }
        return sb.toString();
    }
}