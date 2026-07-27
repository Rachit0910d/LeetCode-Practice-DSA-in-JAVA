class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);

            int todaysProfit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, todaysProfit);
        }

        return maxProfit;
    }
}