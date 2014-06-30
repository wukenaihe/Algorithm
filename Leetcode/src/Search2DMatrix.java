public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		for(int i=0;i<matrix.length;++i){
			int[] temp=matrix[i];
			if(temp[0]<=target&&temp[temp.length-1]>=target){
				int a=0,b=temp.length-1,mid;
				while(a<=b){
					mid=(a+b)/2;
					if(temp[mid]==target){
						return true;
					}else if(temp[mid]<target){
						a=mid+1;
					}else{
						b=mid-1;
					}
				}
				return false;
			}else if(target<temp[0]){
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Search2DMatrix s=new Search2DMatrix();
		int[][] A=new int[][]{{1}};
		System.out.println(s.searchMatrix(A, 1));
	}
}
