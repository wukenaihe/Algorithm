public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if(m==0||n==0){
			return 0;
		}
		int[][] path=new int[m][n];
		for(int i=0;i<n;++i){
			path[0][i]=1;
		}
		for(int i=0;i<m;++i){
			path[i][0]=1;
		}
		
		for(int i=1;i<m;++i){
			for(int j=1;j<n;++j){
				path[i][j]=path[i][j-1]+path[i-1][j];
			}
		}
		return path[m-1][n-1];
	}
	
	public static void main(String[] args) {
		UniquePaths u=new UniquePaths();
		
		System.out.println(u.uniquePaths(1, 1));
		System.out.println(u.uniquePaths(3, 7));
	}
}
