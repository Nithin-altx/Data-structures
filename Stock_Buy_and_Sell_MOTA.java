class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        if(prices==null||prices.length<2)
        return 0;
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:prices)
        {
            if( price<minprice)
            {
                minprice=price;
            }
            else if(price-minprice>maxprofit)
            {
                maxprofit=price-minprice;
            }
        }
        return maxprofit;
    }
}
