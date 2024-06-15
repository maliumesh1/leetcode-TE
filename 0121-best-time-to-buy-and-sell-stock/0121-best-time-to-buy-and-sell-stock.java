class Solution {
static int maxProfit(int[] prices)
 {
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) 
    {
        minPrice = Math.min(minPrice, prices[i]);
        maxPro = Math.max(maxPro, prices[i] - minPrice);
     }
    return maxPro;  
    }
}


