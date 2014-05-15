public class MaxProfit1 {
	public int maxProfit(int[] prices) {
		if(prices.length<2){
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int minPrice=prices[0];
		int l=prices.length;
		int[] dp=new int[l];
		int i=1;
		while(i<l){
			dp[i]=Math.max(dp[i-1], prices[i]-minPrice);
			if(prices[i]<minPrice){
				minPrice=prices[i];
			}
			
			if(max<dp[i]){
				max=dp[i];
			}
			i++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxProfit1 m=new MaxProfit1();
		
		System.out.println(m.maxProfit(new int[]{0,1,2,-3}));
	}
}
