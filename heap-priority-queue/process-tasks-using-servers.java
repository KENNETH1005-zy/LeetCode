class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //use a min heap for the freeServers
        //use another minHeap for used servers

        //{server[i], server index， inital time}
        //use the smallest server[i] fist then the index
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? (a[0] - b[0]) :
            (a[1] - b[1]));
        //{server[i], server index, add in time}
        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> (a[2] != b[2]) ? (a[2] - b[2]) :
            (a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1]));
        //impelent the free servers
        for (int i = 0; i< servers.length; i++) {
            free.offer(new int[]{servers[i], i, 0});
        }
        int[] result = new int[tasks.length];
        //use the index of tasks as time
        for (int i = 0; i< tasks.length; i++) {
            int t = tasks[i];
            while (!used.isEmpty() && used.peek()[2] <= i) {
                free.offer(used.poll());
            }
            if (free.isEmpty()) {
                int[] temp = used.poll();
                result[i] = temp[1];
                temp[2] += t;
                used.offer(temp);
            }else {
                int[] temp = free.poll();
                result[i] = temp[1];
                temp[2] = i + t;
                used.offer(temp);
            }
        }
        return result;
    }
}