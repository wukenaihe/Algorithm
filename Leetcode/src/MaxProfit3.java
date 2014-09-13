public class MaxProfit3 {
	public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }   
        int[] golab=new int[3];
        int[] local=new int[3];
        for(int i=0;i<prices.length-1;++i){
        	int diff=prices[i+1]-prices[i];
        	for(int j=2;j>=1;--j){
        		local[j]=Math.max(golab[j-1]+Math.max(diff, 0), local[j]+diff);
        		golab[j]=Math.max(local[j], golab[j]);
        	}
        }
        return golab[2];
    }
	
	public static void main(String[] args) {
		MaxProfit3 m=new MaxProfit3();
		
		System.out.println(m.maxProfit(new int[]{10,2,3,4,6}));
		System.out.println(m.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
	}
}
