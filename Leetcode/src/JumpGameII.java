public class JumpGameII {
//	public int jump(int[] A) {
//		int[] hep=new int[A.length];
//		int maxCurrent=0;
//		for (int i = 1; i < hep.length; i++) {
//			hep[i]=Integer.MAX_VALUE;
//		}
//		
//		for(int i=0;i<A.length;++i){
//			if(i+A[i]>maxCurrent){
//				maxCurrent=(i+A[i])>=hep.length?hep.length-1:i+A[i];
//				int j=maxCurrent;
//				while(j>i){
//					hep[j]=Math.min(hep[j], hep[i]+1);
//					j--;
//				}
//			}
//		}
//		return hep[hep.length-1];
//	}
	
	public int jump(int[] A) {
		if(A==null||A.length==0){
			return 0;
		}
		int maxCurrent=0;
		int lastReach=0;
		int step=0;
		int i=0;
		for(;i<=maxCurrent&&i<A.length;++i){
			if(i>lastReach){
				step++;
				lastReach=maxCurrent;
			}
			
			maxCurrent=Math.max(maxCurrent, i+A[i]);
			if(maxCurrent>=A.length-1&&i!=A.length-1){
				return step+1;
			}
		}
		if(maxCurrent<A.length){
			return 0;
		}
		return step;
	}
	
	public static void main(String[] args) {
		JumpGameII j=new JumpGameII();
		
//		System.out.println(j.jump(new int[]{2,2,1,2,4}));
//		System.out.println(j.jump(new int[]{2,3,1,1,4}));
		System.out.println(j.jump(new int[]{0}));
	}
}
