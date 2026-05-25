class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        //only 1 to 9 can be used, and at most once
        //size must be k, and the sum is n
        dfs(1, k, n, new ArrayList<>());
        return result;
    }
    public void dfs(int current, int size, int sum, List<Integer> list) {
        //base case
        if (current > 9) {
            return;
        }else if (list.size() == size) {
            if (sum != 0) {
                return;
            }else {
                result.add(new ArrayList<>(list));
                return;
            }
        }else if (sum < 0) {
            return;
        }
        for (int i = current; i<=9; i++) {
            if (list.size() > 0 && list.get(list.size() - 1) == i) continue;
            list.add(i);
            dfs(i, size, sum - i, list);
            list.remove(list.size() - 1);
        }
    }
}