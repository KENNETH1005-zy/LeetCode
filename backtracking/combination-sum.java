class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //set of list
        //return list
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        dfs(0, 0,candidates, target, result, new ArrayList<>());
        return new ArrayList<>(result);
    }
    //dfs to find the set of list that sum is target
    //if total sum is more than target, backtrack to prev
    //iterate in the cands, find the next one
    public void dfs(int i, int sum, int[] candidates, int target, Set<List<Integer>> result, List<Integer> list){
        //base base
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }else if (i >= candidates.length || sum > target) {
            return;
        }

        for (int j = i; j<candidates.length; j++) {
            sum += candidates[j];
            list.add(candidates[j]);

            dfs(j, sum, candidates, target, result, list);

            sum -= candidates[j];
            list.remove(list.size() - 1);
        }
    }
}