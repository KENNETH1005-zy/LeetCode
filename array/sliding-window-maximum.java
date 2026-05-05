class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        // 1. 修正结果数组长度：n - k + 1
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // 2. 优先队列存储 [值, 下标]，值大的在堆顶
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            // 将当前元素加入堆
            pq.add(new int[]{nums[i], i});
            
            // 当索引达到 k-1 时，窗口正式形成
            if (i >= k - 1) {
                // 3. 核心：如果堆顶元素的下标已经不在当前窗口内 (<= i - k)，就弹出
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                // 4. 当前堆顶就是窗口最大值
                result[i - k + 1] = pq.peek()[0];
            }
        }
        return result;
    }
}