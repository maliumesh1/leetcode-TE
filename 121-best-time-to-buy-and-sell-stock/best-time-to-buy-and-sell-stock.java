class Solution {
    public int maxProfit(int[] prices) 
    {
        int bprize = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i=0 ; i<prices.length ; i++ )
        {
            if(bprize <prices[i])
            {
                int profit = prices[i]-bprize ;
                maxprofit = Math.max(maxprofit,profit);
            
            }
            else
            {
                bprize = prices[i] ;
            }
        }
        return maxprofit ;
    }
    public static void main(String args[])
    {
        int prices[] = {1, 3, 5, 7, 9};
        int n = 5;
    }
        
    
}