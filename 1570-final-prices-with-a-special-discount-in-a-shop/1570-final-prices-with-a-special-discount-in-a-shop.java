class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        int i;
        int j;
        for (i = 0; i < prices.length; i++) {
            for (j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    arr[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (j == prices.length) {
                arr[i] = prices[i];
            }
        }
        return arr;
    }

}