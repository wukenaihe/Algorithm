public class RotatedSearch1 {
	public int search(int[] A, int target) {
		int half = half(A, 0, A.length - 1);
		if (half == 0) {
			return binarySearch(A, 0, A.length - 1, target);
		} else if (A[A.length - 1] >= target) {
			return binarySearch(A, half, A.length - 1, target);
		} else if (A[half - 1] >= target) {
			return binarySearch(A, 0, half - 1, target);
		} else {
			return -1;
		}
	}

	public int binarySearch(int[] A, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int half = (start + end) / 2;
		if (A[half] == target) {
			return half;
		} else if (A[half] > target) {
			return binarySearch(A, start, half - 1, target);
		} else {
			return binarySearch(A, half+1, end, target);
		}
	}

	public int half(int[] A, int start, int end) {
		if (A[start] < A[end]) {
			return start;
		}else if(start==end){
			return start;
		}else if (end - start == 1 && A[end] < A[start]) {
			return end;
		}

		int half = (start + end) / 2;
		if (A[half] < A[end]) {
			return half(A, start, half);
		} else {
			return half(A, half, end);
		}
	}

	public static void main(String[] args) {
		RotatedSearch1 rs = new RotatedSearch1();
		int[] A = new int[] { 1 };

		System.out.println(rs.search(A, 1));
	}
}
