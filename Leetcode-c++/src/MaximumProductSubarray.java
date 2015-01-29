
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
        if(A==null){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int num=1;
        int negPointer=Integer.MAX_VALUE;
        for(int i=0;i<A.length;++i){
            num*=A[i];
            int r=num;
            if(r<0&&negPointer<0){
                r/=negPointer;
            }
            max=Math.max(max,r);
            if(negPointer==Integer.MAX_VALUE&&A[i]<=0){
                negPointer=num;
            }
            if(num==0){
            	num=1;
            	negPointer=Integer.MAX_VALUE;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		MaximumProductSubarray m=new MaximumProductSubarray();
		System.out.println(m.maxProduct(new int[]{-2,-2,4,-4}));
		System.out.println(m.maxProduct(new int[]{-2}));
		System.out.println(m.maxProduct(new int[]{2,3,-2,10}));
		System.out.println(m.maxProduct(new int[]{0,2}));
		System.out.println(m.maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
	}
}
