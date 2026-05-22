class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            int curPrice = prices[i];
            if(minPrice > curPrice){
                minPrice = curPrice;
            }else{
                // 只要當前的值比minPrice小就直接賣，然後再把minPrice變成當前的值，因為題目說可以當天買賣
                profit += curPrice - minPrice;
                minPrice = curPrice;
            }
        }

        return profit;
    }
}