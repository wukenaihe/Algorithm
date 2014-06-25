import java.util.Arrays;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int num=m+n-1;
		int i=m-1;
		int j=n-1;
		while(i>=0&&j>=0){
			if(A[i]>B[j]){
				A[num]=A[i];
				i--;
			}else{
				A[num]=B[j];
				j--;
			}
			num--;
		}
		
		while(j>=0){
			A[num]=B[j];
			j--;
			num--;
		}
	}
	
	public static void main(String[] args) {
		MergeSortedArray m=new MergeSortedArray();
		
		int[] A=new int[]{4,5,6,0,0,0};
		int[] B=new int[]{1,2,3};
		
		m.merge(A, 3, B, 3);
		System.out.println(Arrays.toString(A));
	}
}
