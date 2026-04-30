class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        //use double ended deque, to store the smallest int[]
        Deque<Integer> dq = new LinkedList<>();
        int additional = nums.length - k;
        for (int i = 0; i<nums.length; i++) {
            while (!dq.isEmpty() && dq.peekLast() > nums[i] && additional > 0) {
                dq.pollLast();
                additional--;
            }
            dq.addLast(nums[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i<k; i++) {
            result[i] = dq.pollFirst();
        }
        return result;
    }
}