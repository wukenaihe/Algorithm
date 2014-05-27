public class ClimbStairs {
	
	int a1=1;
	int a2=2;
	
	public int climbStairs(int n) {
		if(n==0){
			return 0;
		}else if(n==1){
			return a1;
		}else if(n==2){
			return a2;
		}
		int b = 0;
		for(int i=3;i<=n;++i){
			b=a1+a2;
			a1=a2;
			a2=b;
		}
		return b;
	}
	
	public static void main(String[] args) {
		ClimbStairs c=new ClimbStairs();
		System.out.println(c.climbStairs(4));
	}
}
