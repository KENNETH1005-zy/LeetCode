class Pair {
    int key;
    int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class MyHashMap {
    List<Pair> list;
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        Pair pair = new Pair(key, value);
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).key == key) {
                list.set(i, pair);
                return;
            }
        }
        list.add(pair);
    }
    
    public int get(int key) {
        for (int i = 0; i<list.size(); i++) {
            Pair pair = list.get(i);
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */