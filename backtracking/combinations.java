class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //from 1 to n
        //each set has k nums
        //start from 1
        //iterat in the dfs, for the end, starting forn end + 1
        //if start exceed, return, in the base case
        //start max is n - k + 1
        
        dfs(1, n, k, new ArrayList<>());
    
        return result;
    }
    public void dfs(int start, int n, int k, List<Integer> temp) {
        //base case
        //while temp.size < k, add the end
        //backtracking
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end <= n; end++) {
            temp.add(end);
            dfs(end + 1, n, k, temp);
            temp.remove(temp.size() - 1);
        }
    }
}