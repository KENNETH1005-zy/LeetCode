class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        //size is k
        //find the subsequence that every index in this sequence is smaller
        //than any other subsequence
        //the smaller index num should be as small as possible

        //record the limit of throwing away in the nums
        int additional = nums.length - k;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i<nums.length; i++) {
            //if last one is more than the new num
            //always make sure the num in in the last is smaller than the new num
            while (!dq.isEmpty() && dq.peekLast() > nums[i] && additional > 0) {
                additional--;
                dq.pollLast();
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