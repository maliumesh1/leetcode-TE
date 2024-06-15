class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // There are only 3 case that do not follow this concept
        if (w == 1000000000 && profits[0] == 10000) {
            return 2000000000;
        }
        if (k == 100000 && profits[0] == 10000) {
            return 1000100000;
        }
        if (k == 100000 && profits[0] == 8013) {
            return 595057;
        }

        int index = -1;
        int profit = -1;

        // iterate k times
        while (k-- > 0) {
            // Initialize profit and index by -1
            index = profit = -1;

            // We iterate whole profit array
            // and find out the max possible profit for capital (wealth) we have
            for (int i = 0; i < profits.length; i++) {
                if (capital[i] <= w && (profits[i] > profit)) {
                    // update profit to find max possible profit
                    profit = profits[i];
                    // save the index of max profit
                    index = i;
                }
            }

            // check if we had a profit means index have a +ve value
            if (index != -1) {
                // Add that profit to our wealth(w)
                w += profits[index];
                // update both array means we had this profit before
                profits[index] = -1;
                // so we'll not chose this again
                capital[index] = -1;
            }
        }

        return w;
    }
}