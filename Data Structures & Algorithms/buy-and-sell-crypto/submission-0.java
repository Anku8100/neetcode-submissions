class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int leftMin = prices[0], profitMax = 0;
        for(int i = 1; i< n; i++){
            profitMax = Math.max(profitMax, prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }
        return profitMax;
    }
}
