public class MaxProfit2 {
	public int maxProfit(int[] prices) {
		int length=prices.length;
		int profit=0;
		for(int i=0;i<length-1;++i){
			if(prices[i]<prices[i+1]){
				profit=profit+prices[i+1]-prices[i];
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		MaxProfit2 m=new MaxProfit2();
		System.out.println(m.maxProfit(new int[]{10,2,3,4,6}));
	}
}
