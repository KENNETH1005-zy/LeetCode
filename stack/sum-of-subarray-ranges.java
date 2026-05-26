class Solution {
    public long subArrayRanges(int[] nums) {
        //the question becomes to sum of max - sum of min
        //min should be the smallest one in a range
        //max should be the biggest one in a range
        //use stack to store the indice of nums not dec
        //for calculating the mins, store the index if the new num is more than 
        //last one in stack
        //while stack is not empty, and if index reach the n, or the new num
        //is smaller than last in stack
        //poll the last one out as mid
        //if anything left set as left
        //result -= [mid] * (how many in the right) * (how many in the left)
        //it means the situations when mid num is the smallest one
        //in stack{0, 3, 5} then the num between 3,5 are all bigger than index 5
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        //right could reach the end because when considering the last n - 1
        //the right side need to be counted
        for (int right = 0; right <= n; right++) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] >= nums[right])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result -= (long)nums[mid] * (right - mid) * (mid - left);
            }
            stack.push(right);
        }
        stack.clear();
        for (int right = 0; right <= n; right++) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                result += (long)nums[mid] * (right - mid) * (mid - left);
            }
            stack.push(right);
        }
        return result;
    }
}