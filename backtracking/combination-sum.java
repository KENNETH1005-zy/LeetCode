class Solution {
    List<List<Integer>> result;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        //if added this new num is smaller than the target
        //add the current num
        //sort the array
        //if the last one left is still not
        this.candidates = candidates;
        dfs(0, new ArrayList<>(), target);
        return result;
    }
    public void dfs(int index, List<Integer> list, int target) {
        //base case
        if (target < 0) {
            return;
        }else if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        //start from the current index find others 
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}