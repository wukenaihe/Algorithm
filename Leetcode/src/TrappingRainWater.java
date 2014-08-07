
public class TrappingRainWater {
	public int trap(int[] A) {
		if(A==null||A.length==0){
			return 0;
		}
		int[] container=new int[A.length];
		int max=0;
		int count=0;
		for(int i=0;i<A.length;++i){
			container[i]=max;
			max=max<A[i]?A[i]:max;
		}
		max=0;
		for(int i=A.length-1;i>=0;i--){
			int num=Math.min(container[i], max)-A[i];
			if(num>0){
				count+=num;
			}
			max=max<A[i]?A[i]:max;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		TrappingRainWater t=new TrappingRainWater();
		System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
