class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;

        for (int ele : rolls)
            sum += ele;
        int val = mean * (m + n) - sum;

        if (val > n * 6 || val < n)
            return new int[0];

        int result[] = new int[n];
        int num = val / n;
        int rem = val % n;

        for (int i = 0; i < rem; i++)
            result[i] = num + 1;
        for (int i = rem; i < n; i++)
            result[i] = num;

        return result;
    }

}