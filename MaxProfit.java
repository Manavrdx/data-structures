public class MaxProfit {
    public static void main(String arr[]){
        int[] prices = {1, 2};
        System.out.println(maxProfitUsingBruteForce(prices));
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int leastStockValue = Integer.MAX_VALUE;
        int profit = 0;

        for (int val: prices) {
            if (leastStockValue > val) {
                leastStockValue = val;
            }
            int diff = val - leastStockValue;
            if (diff > profit) {
                profit = diff;
            }
        }
        return profit;
    }

    public static int maxProfitUsingBruteForce(int[] prices) {
        int length = prices.length;
        int max = 0;

        for(int i = 0; i <= length-2; i++) {
            for(int j = i+1; j <= length-1; j++) {
                int diff = prices[j] - prices[i];
                max = Math.max(max, diff);
            }
        }
        return max;
    }
}
