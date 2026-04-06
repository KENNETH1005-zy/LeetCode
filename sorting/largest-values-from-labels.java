class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //number at most numWanted
        //number of item with same labe at most useLimit

        //in the same lable, pick the one has the most value
        //store the values and lables pair in the pq
        //if exceed the limit, poll until a new lable
        //if reach the most wanted, break
        int result = 0;
        //{value, lable}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i< values.length; i++) {
            pq.offer(new int[]{values[i], labels[i]});
        }

        int count = 0;
        //map to store the count of lables
        //{lable, count}
        Map<Integer, Integer> map = new HashMap<>();
        
        while (count < numWanted && !pq.isEmpty()) {
            int[] temp = pq.poll();
            int value = temp[0];
            int label = temp[1];

            if (!map.containsKey(label) || map.get(label) < useLimit) {
                result += value;
                count++;
                map.put(label, map.getOrDefault(label, 0) + 1);
            }else {
                continue;
            }
        }
        return result;
    }
}