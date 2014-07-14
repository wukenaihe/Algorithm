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
		if(i>j){
			return result;
		}
		int start=mid;
		while(start>=i&&A[start]==target){
			result[0]=start;
			start--;
		}
		int end=mid;
		while(end<=j&&A[end]==target){
			result[1]=end;
			end++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		SearchforRange s=new SearchforRange();
		System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
	}
}
