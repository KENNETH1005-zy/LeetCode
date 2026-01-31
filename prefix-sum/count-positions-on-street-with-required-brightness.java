class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        
        int[] counter = new int[n];
        for(int[] l :lights)
        {
            int p = l[0];
            int r = l[1];
            int leftBound = Math.max(0,p-r);
            int rightBound = Math.min(n-1,p+r);
            counter[leftBound]++;
            if(rightBound<n-1)
                counter[rightBound+1]--;
        }

        int prefixSum=0;
        int count=0;
        for(int i =0;i<n;i++)
        {
            prefixSum = prefixSum + counter[i];
            if(prefixSum >=requirement[i])
                count++;
        }

        return count;
    }
}