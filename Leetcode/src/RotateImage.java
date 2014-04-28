import java.util.Arrays;

public class RotateImage {
//	public void rotate(int[][] matrix) {
//		int l=matrix.length;
//		int[][] temp=new int[l][l];
//		for(int i=0;i<l;++i){
//			for(int j=0;j<l;++j){
//				temp[i][j]=matrix[i][j];
//			}
//		}
//		
//		for(int i=0;i<l;++i){
//			for(int j=0;j<l;++j){
//				matrix[i][j]=temp[l-j-1][i];
//			}
//		}
//	}
	public void rotate(int[][] matrix) {
		rotate(matrix,0,0,matrix.length);
	}
	
	public void rotate(int[][] matrix,int x,int y,int length){
		if(length==0||length==1){
			return;
		}
		int l=matrix.length;
		int temp1,temp2;
		temp1=matrix[x][y+length-1];
		matrix[x][y+length-1]=matrix[x][y];
		
		temp2=matrix[x+length-1][y+length-1];
		matrix[x+length-1][y+length-1]=temp1;
		
		temp1=matrix[x+length-1][y];
		matrix[x+length-1][y]=temp2;
		
		matrix[x][y]=temp1;
		
		
		
		for(int i=y+1;i<y+length-1;++i){
			
			temp1=matrix[i][l-x-1];
			matrix[i][l-x-1]=matrix[x][i];
			
			temp2=matrix[l-x-1][l-i-1];
			matrix[l-x-1][l-i-1]=temp1;
			
			matrix[x][i]=matrix[l-i-1][x];
			matrix[l-i-1][x]=temp2;
			
			
		}
		
		rotate(matrix,x+1,y+1,length-2);
	}
	
	public static void main(String[] args) {
//		int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix=new int[][]{{1,2},{3,4}};

		RotateImage r=new RotateImage();
		
		r.rotate(matrix);
		for(int i=0;i<matrix.length;++i){
			int[] m=matrix[i];
			System.out.println(Arrays.toString(m));
		}
		
	}
}
