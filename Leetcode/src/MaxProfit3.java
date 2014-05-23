public class MaxProfit3 {
	int[] f;
	int[] e;
	public int maxProfit(int[] prices) {
		int l=prices.length;
		if(l<2){
			return 0;
		}
		maxProfitF(prices);
		maxProfitS(prices);
		int max=0;
		for(int i=1;i<l-2;i++){
			int a1=f[i]+e[i+1];
			if(a1>max){
				max=a1;
			}
		}
		
		if(max<f[l-2]){
			max=f[l-2];
		}
		if(max<f[l-1]){
			max=f[l-1];
		}
		
		return max;
	}
	
	public void maxProfitF(int[] prices){
		int l=prices.length;
		f=new int[l];
		
		int minPrice=prices[0];
		int i=1;
		while(i<l){
			f[i]=Math.max(f[i-1], prices[i]-minPrice);
			if(prices[i]<minPrice){
				minPrice=prices[i];
			}
			i++;
		}
	}
	
	public void maxProfitS(int[] prices){
		int l=prices.length;
		e=new int[l];
		
		int maxPrice=prices[l-1];
		int i=l-2;
		while(i>=0){
			e[i]=Math.max(e[i+1], maxPrice-prices[i]);
			if(prices[i]>maxPrice){
				maxPrice=prices[i];
			}
			i--;
		}
	}
	
	public static void main(String[] args) {
		MaxProfit3 m=new MaxProfit3();
		
		System.out.println(m.maxProfit(new int[]{10,2,3,4,6}));
	}
}
