class Solution {
    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();

        int j = arr.length - 1;
        long ans = 0;
        int counter = 0;
        while (j >= 0) {
            if (arr[j] == '0') // Calculating the cost to swap from next occurrence of 1.
                counter++;
            else if (arr[j] == '1') { // Encounter a 1, add that cost to the ans.
                ans += counter; // Since next 1 we will encounter will ecounter the same amount of zeros in
                                // between that 1 and the zeros it has to swap thru, therefore we don't need to
                                // reset zero count.
            }
            // Ex: 11000111, first one swaps by the count of 3 zeros. so
            // -- > 10001111
            // Immediately we encounter another 1, so it costs the same to move that 1.
            // Therefore, unless we encounter new zeros that add to the cost, we will repeat
            // the same process.
            j--;
        }
        return ans;
    }

}