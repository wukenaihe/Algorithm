public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank=0;
		int N=gas.length;
		int i=0;
		while(i<N){
			int j=i+1;
			int p=j%N;
			tank+=gas[i];
			tank-=cost[i];
			while(p!=i){
				if(tank<0){
					break;
				}
				tank+=gas[p];
				tank-=cost[p];
				j++;
				p=j%N;
			}
			if(p==i&&tank>=0){
				return i;
			}
			if(p<=i){
				return -1;
			}else{
				i=p;
			}
			
			tank=0;
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		GasStation gs=new GasStation();
		System.out.println(gs.canCompleteCircuit(new int[]{1,2,4,4}, new int[]{2,1,3,4}));
		System.out.println(gs.canCompleteCircuit(new int[]{4}, new int[]{5}));

	}
}
