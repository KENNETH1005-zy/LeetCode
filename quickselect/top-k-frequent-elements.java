class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //use max pq to store the count and the num
        //return the top most
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            maxHeap.add(new int[]{count, num});
        }

        int count = 0;
        int[] result = new int[k];
        while (count < k && !maxHeap.isEmpty()) {
            int[] set = maxHeap.poll();
            int num = set[1];
            result[count++] = num;
        }
        return result;
    }
}