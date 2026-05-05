class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //list to store the result
        //dq to store the max in a window
        //add first for the max
        //if first one is out of the bound, poll that out
        //in every iteration, if the last one in the queue is smaller than the num
        //poll that

        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        //for the first k nums
        for (int i = 0; i<k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        result.add(nums[dq.peekFirst()]);
        //first one is always the biggest one
        for (int i = k; i<nums.length; i++) {
            if (i - k == dq.peekFirst()) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            result.add(nums[dq.peekFirst()]);
        }
        return result.stream().mapToInt(Integer :: intValue).toArray();
    }
}