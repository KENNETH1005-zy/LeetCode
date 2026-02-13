class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, temp, result);
        return result;
    }
    public void dfs(int index, int[] nums, List<Integer> temp, List<List<Integer>> result){
        //add the temp to the result
        //iterate in the nums, recursively add the num
        //the recurstion will be terminated if index is more than length ny itself
        result.add(new ArrayList<>(temp));
        //a object to determin whther this is the same num in the same recursion
        Integer lastNum = null;
        for (int i = index; i<nums.length; i++) {
            //if there are the same num in the same recurion, jump to next
            if (lastNum != null && lastNum == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(i + 1, nums, temp, result);
            //undo
            temp.remove(temp.size() - 1);
            lastNum = nums[i];
        }
    }
}