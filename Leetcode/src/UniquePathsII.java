public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int xLength=obstacleGrid.length;
		if(xLength==0){
			return 0;
		}
		int yLength=obstacleGrid[0].length;
		int[][] nums=new int[xLength][yLength];
		
		for(int i=0;i<xLength;++i){
			if(obstacleGrid[i][0]==0){
				nums[i][0]=1;
			}else{
				break;
			}
		}
		for(int i=0;i<yLength;++i){
			if(obstacleGrid[0][i]==0){
				nums[0][i]=1;
			}else{
				break;
			}
		}
		
		for(int i=1;i<xLength;++i){
			for(int j=1;j<yLength;++j){
				if(obstacleGrid[i][j]==0){
					nums[i][j]=nums[i-1][j]+nums[i][j-1];
				}
			}
		}
		
		return nums[xLength-1][yLength-1];
	}
	
	public static void main(String[] args) {
		int[][] obs=new int[][]{
				{1,0,0},
				{0,1,0},
				{0,0,0}
		};
		
		UniquePathsII u=new UniquePathsII();
		System.out.println(u.uniquePathsWithObstacles(obs));
	}
}
