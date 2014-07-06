public class MaximalRectangle {
	//正方形，错了
//	public int maximalRectangle(char[][] matrix) {
//		int l1=matrix.length;
//		if(l1==0){
//			return 0;
//		}
//		int l2=matrix[0].length;
//		int max=0;
//		for(int i=0;i<l1-max;++i){
//			for(int j=0;j<l2-max;++j){
//				char c=matrix[i][j];
//				if(c=='1'){
//					int k=0;
//					while(i+k<l1&&j+k<l2){
//						boolean rect=true;
//						for(int z=i;z<=i+k;++z){
//							char c1=matrix[z][j+k];
//							if(c1!='1'){
//								rect=false;
//								break;
//							}
//						}
//						for(int z=j;z<=j+k;++z){
//							char c1=matrix[i+k][z];
//							if(c1!='1'){
//								rect=false;
//								break;
//							}
//						}
//						if(!rect){
//							break;
//						}
//						if(k+1>max){
//							max=k+1;
//						}
//						k++;
//					}
//				}
//			}
//		}
//		return max;
//		
//	}
	public int maximalRectangle(char[][] matrix){
		int l1=matrix.length;
		if(l1==0){
			return 0;
		}
		int l2=matrix[0].length;
		int max=0;
		for(int i=0;i<l1;++i){
			int temp=0;
			for(int j=0;j<l2;++j){
				if(j==0&&matrix[i][j]=='1'){
					temp=1;
				}else if(matrix[i][j]=='1'&&matrix[i][j-1]=='1'){
					temp++;
					max=max<temp?temp:max;
				}else if(matrix[i][j]=='1'&&matrix[i][j-1]!='1'){
					temp=1;
				}
			}
		}
		for(int i=0;i<l2;++i){
			int temp=0;
			for(int j=0;j<l1;++j){
				if(j==0&&matrix[j][i]=='1'){
					temp=1;
				}else if(matrix[j][i]=='1'&&matrix[j-1][i]=='1'){
					temp++;
				}else if(matrix[j][i]=='1'&&matrix[j-1][i]!='1'){
					temp=1;	
				}
				max=max<temp?temp:max;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximalRectangle m=new MaximalRectangle();
		
		System.out.println(m.maximalRectangle(new char[][]{{'0','0','0'},{'1','1','1'},{'0','1','1'}}));
		System.out.println(m.maximalRectangle(new char[][]{{'0','0','0'},{'0','1','1'},{'0','0','1'}}));
		System.out.println(m.maximalRectangle(new char[][]{{'0','1'},{'0','1'}}));


	}
	

}
