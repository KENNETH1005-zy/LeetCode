class Solution {
    public int countDays(int days, int[][] meetings) {
        //sort the meetings by the starting time
        Arrays.sort(meetings, (a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }else {
                return Integer.compare(b[1], a[1]);
            }
        });

        //merge the intervals with the same time duration
        //every duration the total day is right - left + 1
        List<int[]> list = new ArrayList<>();
        for (int[] meeting: meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (list.isEmpty()) {
                list.add(new int[]{start, end});
                continue;
            }
            //compare with the previous interval
            int[] prev = list.get(list.size() - 1);
            int prevStart = prev[0];
            int prevEnd = prev[1];

            if (start > prevEnd) {
                list.add(new int[]{start, end});
                continue;
            }else if (start <= prevEnd) {
                list.set(list.size() - 1, new int[]{prevStart, Math.max(end, prevEnd)});
            }
        }
        //count the number of days
        int count = 0;
        for (int[] meeting: list) {
            count += meeting[1] - meeting[0] + 1;
        }
        return days - count;
    }
}