class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; // Start from 1 (since lexicographical starts with 1, not 0)
        k--; // Decrease k by 1 because the 1st number is '1', not '0'

        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1); // Count the steps between curr and curr+1
            if (steps <= k) { // If the steps are less than or equal to k, move to the next prefix
                curr++;
                k -= steps;
            } else { // Otherwise, drill down in the current prefix
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // Function to count the steps between two numbers in lexicographical order
    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }

}