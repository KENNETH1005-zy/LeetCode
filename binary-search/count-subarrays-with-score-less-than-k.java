class Solution {
    public long countSubarrays(int[] nums, long k) {
        //count to return the count
        //running sum for all the nums in a window
        //if valid, add the count
        //while sum > k remove the nums[left]
        //add the count after it
        //return count
        Long count = 0l;
        //using double ended queue
        Deque<Integer> dq = new LinkedList<>();
        int left = 0;
        Long sum = 0l;
        for (int right = 0; right < nums.length; right++) {
            dq.addLast(nums[right]);
            int size = dq.size();
            sum += nums[right];
            
            while (sum * size >= k && !dq.isEmpty()) {
                int temp = dq.pollFirst();
                sum -= temp;
                size = dq.size();
                left++;
            }
            if (!dq.isEmpty()) {
                count += right - left + 1;
            }
        }
        return count;
    }
}