package neetcode.blind75;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] numbers = new int[]{10,1,5,6,7,1};
        int result;
        BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();
        result = bestTimeToBuyAndSell.maxProfit(numbers);
        System.out.println(result);
    }
    public int maxProfit(int[] prices) {
        int i=0;
        int j=1;
        int maxProfit=0;
        int currentMaxProfit=0;

        while(j<prices.length){
            if(prices[j]-prices[i]>0){
                currentMaxProfit = prices[j]-prices[i];
                j++;
                if(maxProfit<currentMaxProfit){
                    maxProfit = currentMaxProfit;
                }
            }
            else{
                i=j;
                j++;
            }

        }
        return maxProfit;
    }
}
