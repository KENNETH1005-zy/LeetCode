class FindSumPairs {
    //update the nums1 and nums2 globally
    int[] nums1;
    int[] nums2;
    //a hash to find if there is tot - num
    //{num, index}
    Map<Integer, Set<Integer>> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int i = 0; i<nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], new HashSet<>());
            }
            map.get(nums2[i]).add(i);
        }
    }
    
    public void add(int index, int val) {
        //add the val to the index
        //like nums2[index] += val
        int prev = nums2[index];
        nums2[index] += val;
        if (map.containsKey(prev)) {
            if (map.get(prev).contains(index)) {
                map.get(prev).remove(index);
            }
            if (map.get(prev).size() == 0) {
                map.remove(prev);
            }
        }
        //add the new value to the map
        if (!map.containsKey(nums2[index])) {
            map.put(nums2[index], new HashSet<>());
        }
        map.get(nums2[index]).add(index);
    }
    
    public int count(int tot) {
        //count the total number of pairs that the two sum is tot
        //find the value that we are searching for
        int result = 0;
        for (int i = 0; i<nums1.length; i++) {
            int value = tot - nums1[i];
            if (map.containsKey(value)) {
                result += map.get(value).size();
            }
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */