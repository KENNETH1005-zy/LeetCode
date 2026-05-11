class Solution {
    public int lengthOfLIS(int[] nums) {
        //use list to store the increasing subsequence
        //if the current one is bigger just append to the list
        //else if smaller, use binary search to find the first one index that
        //if euqual or bigger than the current num
        //and set at that index the current num
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i<nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            }else {
                int j = bs(nums[i], list);
                list.set(j, nums[i]);
            }
        }
        return list.size();
    }
    public int bs(int num, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r){
            int mid = l + (r - l) / 2;

            if (list.get(mid) == num) {
                return mid;
            }

            if (list.get(mid) > num) {
                r = mid;
            }else {
                l = mid + 1;
            }
        } 
        return l;
    }
}