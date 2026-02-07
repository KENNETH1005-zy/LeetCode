class Solution {
    public int totalFruit(int[] fruits) {
        //can only collect two types of fruits
        //max to hold largest num
        int left = 0;
        //a set to store the element
        //while right pointer is smaller than the length
        //if contains in set, max = new Max(right - left + 1)
        //if not contains, remove the left element
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int max = Integer.MIN_VALUE;
        while (right < fruits.length) {
            int type = fruits[right];
            map.put(type, map.getOrDefault(type, 0) + 1);
            if (map.size() <= 2) {
                max = Math.max(max, right - left + 1);
            }

            while (map.size() > 2 && left <= right) {
                int temp = fruits[left];
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) <= 0) {
                    map.remove(temp);
                }
                left++;
            }
            right++;
        }
        return max;
    }
}