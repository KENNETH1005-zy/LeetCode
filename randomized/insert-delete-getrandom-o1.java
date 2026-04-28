class RandomizedSet {
    Random rand = new Random();
    List<Integer> list;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        //true if val was not present
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        //true if val is present
        if (map.containsKey(val)) {
            int index = map.get(val);
            list.remove(index);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */