class FirstUnique {
    //use a map to store the num and the indice
    //find the unique one that occurs first
    Map<Integer, PriorityQueue<Integer>> map;
    List<Integer> list;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        list = new ArrayList<>();
        for (int num: nums) {
            list.add(num);
        }
        for (int i = 0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new PriorityQueue<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int showFirstUnique() {
        //find the first unique one that occurs

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: map.keySet()) {
            if (map.get(num).size() == 1) {
                pq.add(map.get(num).peek());
            }
        }
        return pq.isEmpty() ? -1 : list.get(pq.peek());

    }
    
    public void add(int value) {
        list.add(value);
        if (!map.containsKey(value)) {
            map.put(value, new PriorityQueue<>());
        }
        map.get(value).add(list.size() - 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */