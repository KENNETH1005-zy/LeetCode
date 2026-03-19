class Solution {
    public int lengthOfLIS(int[] nums) {
        //list to store the valid subsequence
        //add the first num
        //iterate from 1th num, if valid add to the list
        //if not valid, find the first index that is smaller or equal to current num
        //replace it in the list result
        //return list size
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        for (int i = 1; i<nums.length; i++) {
            int num = nums[i];
            if (num > result.get(result.size() - 1)) {
                result.add(num);
            }else {
                int j = find(result, num);
                result.set(j, num);
            }
        }
        return result.size();
    }
    public int find(List<Integer> result, int num) {
        int l = 0;
        int r = result.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (result.get(mid) == num) return mid;
            if (num > result.get(mid)) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}