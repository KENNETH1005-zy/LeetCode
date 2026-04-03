class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Intialize an empty set<List<Integer>> to avoid duplicate
        Set<List<Integer>> resultSet = new HashSet<>();

        if (nums == null || nums.length < 3) {
            return new ArrayList<> (resultSet);
        }
        Arrays.sort(nums);
        
        for (int i = 0 ;i < nums.length - 2; i++) {
            //find opposite of nums[i]
            int c = -nums[i];
            Set <Integer> seen = new HashSet<>();
            for (int j = i + 1 ; j < nums.length; j ++) {
                int d = c - nums[j];
                if (seen.contains(d)) {
                    List<Integer> single = Arrays.asList(nums[i], nums[j], d);
                    resultSet.add(single);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(resultSet);
    }
}