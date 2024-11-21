class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int profit=0;
        int buy=prices[0];
        int sp=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i-1]<prices[i])
            {
                buy=prices[i];
            }
            else{
                profit+=buy-sp;
                buy=prices[i];
                sp=prices[i];
            }
            
        }
        profit+=buy-sp;
        return profit;
    }
}
