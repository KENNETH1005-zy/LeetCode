class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //use two deque, one fir store min from small to big
        //anther one for big to small
        //sliding window, iterate the nums
        //while max is not null and peek last one is smaller than current num, poll last
        //while min is not null and peek last is bigger than current num, poll last
        //while max peek first max and min is more than limit
        //poll the one that is the nums[left], shrink the window lef++
        //update the longest
        //return longest

        int longest = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[r]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[r]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == nums[l]) {
                    minDeque.pollFirst();
                }
                l++;
            }
            longest = Math.max(longest, r - l + 1);  
        }
        return longest;
    }
}