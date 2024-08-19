class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        int minOperations = 0;

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                minOperations += i;
            }
            if (n == 1) {
                break;
            }
        }

        return minOperations;
    }

}