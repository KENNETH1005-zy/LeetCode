class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //map to store the translation realtionship
        //smallest is 1
        //sort the arr
        //name it from the beginning
        //find the relative rank
        if (arr.length == 0) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        int rank = 1;
        map.put(temp[0], 1);
        for (int i = 1; i<temp.length; i++) {
            if (temp[i] > temp[i - 1]) {
                rank += 1;
                map.put(temp[i], rank);
            }
        }    
        int [] result = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}