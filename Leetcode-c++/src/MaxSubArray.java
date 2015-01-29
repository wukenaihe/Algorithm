public class MaxSubArray {
	public int maxSubArray(int[] A) {
		int max=A[0],sum=0;
		
		for(int i=0;i<A.length;++i){
			sum=sum+A[i];
			if(sum>max){
				max=sum;
			}
			if(sum<0){
				sum=0;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaxSubArray m=new MaxSubArray();
		System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(m.maxSubArray(new int[]{-2,1,-3}));

	}
}
