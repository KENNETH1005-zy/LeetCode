class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //an array to store the mod
        //if has the same mod, means a - b 's mod of k is 0
        //use prefix mod
        int prefixMod = 0;
        int result = 0;
        //mod range is 0 to k - 1
        int[] mod = new int[k];
        //if the prefix mod is 0, count is initailly 1
        mod[0] = 1;

        for (int i = 0; i<nums.length; i++) {
            prefixMod = (prefixMod + nums[i] % k + k) % k;

            result += mod[prefixMod];
            mod[prefixMod]++;
        }
        return result;
    }
}