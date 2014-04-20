import java.util.Arrays;

public class SetZeros {
	public void setZeroes(int[][] matrix) {
		int m=matrix.length;
		if(m==0){
			return;
		}
		int n=matrix[0].length;
		if(n==0){
			return;
		}
		
		boolean row=false,column=false;
		for(int i=0;i<n;++i){
			if(matrix[0][i]==0){
				row=true;
				break;
			}
		}
		
		for(int i=0;i<m;++i){
			if(matrix[i][0]==0){
				column=true;
				break;
			}
		}
		
		for(int i=1;i<m;++i){
			for(int j=1;j<n;++j){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<n;++i){
			if(matrix[0][i]==0){
				for(int j=1;j<m;++j){
					matrix[j][i]=0;
				}
			}
			if(row){
				matrix[0][i]=0;
			}
		}
		
		for(int i=1;i<m;++i){
			if(matrix[i][0]==0){
				for(int j=1;j<n;++j){
					matrix[i][j]=0;
				}
			}
			if(column){
				matrix[i][0]=0;
			}
		}
		if(row||column){
			matrix[0][0]=0;
		}
	}
	
	public static void main(String[] args) {
		SetZeros sz=new SetZeros();
		int[][] matrix=new int[][]{{1,0}};
		sz.setZeroes(matrix);
		System.out.println(Arrays.toString(matrix));
	}
}
