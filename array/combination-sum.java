class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //create the result
        result = new ArrayList<>();
        //dfs to find the sum is target
        dfs(0, candidates, target, new ArrayList<>());
        return result;
    }
    //helper function
    public void dfs(int index, int[] candidates, int target, List<Integer> list) {
        //base case
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }else if (target < 0) {
            return;
        }
        for (int i = index; i<candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], list);
            //backtracking
            list.remove(list.size() - 1);
        }
    }
}