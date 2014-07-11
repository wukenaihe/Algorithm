import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		int start = 0;
		if (A.length == 1||A.length==0) {
			return A.length;
		}
		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] == A[i + 1]) {
				break;
			}
			start++;
		}
		if(start==A.length-1){
			return A.length;
		}
		for (int i = start + 2; i < A.length; ++i) {
			if (A[i] != A[start]) {
				A[start+1] = A[i];
				start++;
			}
		}
		return start+1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		int[] A = new int[] { -1,0,0,3,3};
		System.out.println(r.removeDuplicates(A));
		System.out.println(Arrays.toString(A));
	}
}
