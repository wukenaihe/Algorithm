import java.util.Arrays;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result=new int[n][n];
		int layer=n/2;
		int count=1;
		for(int i=0;i<layer;++i){
			for(int j=i;j<n-i-1;++j){
				result[i][j]=count++;
			}
			
			for(int j=i;j<n-i-1;++j){
				result[j][n-i-1]=count++;
			}
			
			for(int j=n-i-1;j>i;--j){
				result[n-1-i][j]=count++;
			}
			
			for(int j=n-i-1;j>i;--j){
				result[j][i]=count++;
			}
		}
		
		if((n&1)==1){
			result[layer][layer]=count;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		SpiralMatrixII s=new SpiralMatrixII();
		
		int[][] res=s.generateMatrix(1);
		
		for (int[] is : res) {
			System.out.println(Arrays.toString(is));
		}
	}
}
