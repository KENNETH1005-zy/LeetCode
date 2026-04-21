class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //combine the sum, if the sum is equal to the target
        //dfs to add the target sum list
        result = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>());
        return result;
    }
    public void dfs(int index, int[] candidates, int target, List<Integer> list) {
        //base case
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            result.add(new ArrayList<>(list));
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