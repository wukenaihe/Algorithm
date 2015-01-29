public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length==0||cost==null||cost.length==0){
            return -1;
        }
        int sum=0;
        int total=0;
        int pointer=-1;
        
        for(int i=0;i<gas.length;++i){
            int diff=gas[i]-cost[i];
            sum+=diff;
            total+=diff;
            if(sum<0){
                sum=0;
                pointer=i;
            }
        }
        return total>=0?pointer+1:-1;
    }
	
	public static void main(String[] args) {
		GasStation gs=new GasStation();
		System.out.println(gs.canCompleteCircuit(new int[]{1,2,4,4}, new int[]{2,1,3,4}));
		System.out.println(gs.canCompleteCircuit(new int[]{4}, new int[]{5}));

	}
}
