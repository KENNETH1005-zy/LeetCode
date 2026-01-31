class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int lightNum = lights.length;
        //store the brightness of each point in a array
        //store the light and it's scope in a map
        //at every point, iterate the lights map, if in bound, current index's brightness + 1
        //global count, after, iteration, if meets the requirement, add 1
        int[] brightness = new int[n];
        Map <Integer, int[]> map = new HashMap<>();
        for (int i = 0; i< lightNum; i++) {
            int index = lights[i][0];
            int scope = lights[i][1];

            map.put(i, new int[]{index - scope, index + scope});
        }
        int count = 0;
        //iterare every location
        for (int i = 0; i<n; i++) {
            for (int[] single: map.values()) {
                int start = single[0];
                int end = single[1];

                if (i >= start && i <= end) {
                    brightness[i]++;
                }
            }
            if (brightness[i] >= requirement[i]) {
                count++;
            }
        }
        return count;
    }
}