class Solution {
    public List<Integer> partitionLabels(String s) {
        //store the first occur in array
        //as well as last occur
        //fill last array all with  -1
        //list adding the length for each partition
        List<Integer> result = new ArrayList<>();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        int start = 0;
        int end = 0;

        for (int i = 0; i<s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i<s.length(); i++) {
            //if it occurs first, add it to the first array
            //if end is smaller than current start, create a new partition, and add it to the result
            //restart the start and the end
            //update
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }

            if (end < first[s.charAt(i) - 'a']) {
                result.add(end - start + 1);
                start = i;
                end = i;
            }

            end = Math.max(end, last[s.charAt(i) - 'a']);
        }
        //add the rest
        if (end - start + 1 > 0) {
            result.add(end - start + 1);
        }
        return result;
    }
}