import java.util.Arrays;

public class SearchforRange {
	public int[] searchRange(int[] A, int target) {
		int[] result=new int[]{-1,-1};
		int i=0,j=A.length-1;
		int mid=0;
		while(i<=j){
			mid=i+(j-i)/2;
			if(target==A[mid]){
				break;
			}else if(A[mid]<target){
				i=mid+1;
			}else{
				j=mid-1;
			}
		}
		if(A[mid]!=target){
			return result;
		}
		int m=mid;
		j=mid-1;
		while(i<=j){
			mid=i+(j-i)/2;
			if(A[mid]!=target){
				i=mid+1;
			}else{
				j=mid-1;
			}
		}
		result[0]=i;
		i=m+1;
		j=A.length-1;
		while(i<=j){
			mid=i+(j-i)/2;
			if(A[mid]!=target){
				j=mid-1;
			}else{
				i=mid+1;
			}
		}
		result[1]=j;
		
		return result;
	}
	
	public static void main(String[] args) {
		SearchforRange s=new SearchforRange();
		System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
	}
}
