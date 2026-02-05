class Solution {
    public int minSteps(int n) {
        //the factor value it self represent the steps
        //like factor is 3, it represent the smallest unit, to make, which is CPP
        int result = 0;
        int prime = 2;

        while (n != 1) {
            while (n % prime == 0) {
                result += prime;
                n /= prime;
            }
            prime++;
        }
        return result;
    }
}