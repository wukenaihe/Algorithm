import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int length = A.length;
		int i = 0;
		int start = 0;
		while (i < length) {
			int j = i + 1;
			if (j == length) {
				A[start++]=A[i];
				break;
			}
			while (j < length && A[i] == A[j]) {
				j++;
			}
			if(j==i+1){
				A[start++]=A[i];
			}else{
				A[start++]=A[i];
				A[start++]=A[i];
			}
			i = j;
		}
		return start;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII r=new RemoveDuplicatesfromSortedArrayII();
		int[] A=new int[]{1,1,1,2};
		System.out.println(r.removeDuplicates(A));
		System.out.println(Arrays.toString(A));
	}
}
