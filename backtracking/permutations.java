class Solution {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        this.nums = nums;
        helper(0);
        return result;
    }
    public void helper(int index) {
        //base case, find the valid list
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num: nums) {
                list.add(num);
            }
            result.add(new ArrayList<>(list));
            return;
        }
        //starting from the the current index
        //swap it with the current and the next one in the array
        for (int j = index; j<nums.length; j++) {
            swap(index, j);
            helper(index + 1);
            //backtracking
            swap(index, j);
        }
    }
    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}