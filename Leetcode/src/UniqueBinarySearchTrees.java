public class UniqueBinarySearchTrees {
	int[] nums;
	public int numTrees(int n) {
		nums=new int[n+1];
		if(n<=2){
			return n;
		}
		nums[0]=1;
		nums[1]=1;
		nums[2]=2;
		
		for(int i=3;i<=n;++i){
			int sum=0;
			for(int j=1;j<=i;++j){
				sum=sum+nums[j-1]*nums[i-j];
			}
			nums[i]=sum;
		}
		return nums[n];
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees u=new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(4));
	}
}
