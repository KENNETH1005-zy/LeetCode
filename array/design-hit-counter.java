class HitCounter {
    //a queue that size is 300, once smaller or equal to timestamp - 300
    //exclude it from the queue
    Deque<Integer> dq;
    public HitCounter() {
        dq = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        dq.addLast(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!dq.isEmpty() && dq.peekFirst() + 300 <= timestamp) {
            dq.pollFirst();
        }
        return dq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */