public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int l1=grid.length;
		if(l1==0){
			return 0;
		}
		int l2=grid[0].length;
		
		int[][] path=new int[l1][l2];
		int sum=0;
		for(int i=0;i<l2;++i){
			sum+=grid[0][i];
			path[0][i]=sum;
		}
		sum=0;
		for(int i=0;i<l1;++i){
			sum+=grid[i][0];
			path[i][0]=sum;
		}
		
		for(int i=1;i<l1;++i){
			for(int j=1;j<l2;++j){
				path[i][j]=Math.min(path[i-1][j], path[i][j-1])+grid[i][j];
			}
		}
		
		return path[l1-1][l2-1];
	}
	
	public static void main(String[] args) {
		MinimumPathSum m=new MinimumPathSum();
		int[][] grid=new int[][]{{1}};
		System.out.println(m.minPathSum(grid));
	}
}
