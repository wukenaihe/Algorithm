public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if (((A.length + B.length) & 1) == 1) {
			return findNum(A, B, 0, A.length - 1, 0, B.length - 1,
					(A.length + B.length) / 2 + 1);
		} else {
			return (findNum(A, B, 0, A.length - 1, 0, B.length - 1,
					(A.length + B.length) / 2) + findNum(A, B, 0, A.length - 1,
					0, B.length - 1, (A.length + B.length) / 2 + 1)) / 2.0;
		}

	}

	private int findNum(int[] A, int[] B, int startA, int endA, int startB,
			int endB, int num) {
		int m = endA - startA + 1;
		int n = endB - startB + 1;

		if (m > n) {
			return findNum(B, A, startB, endB, startA, endA, num);
		}
		if (m == 0) {
			return B[startB + num - 1];
		}
		if (num == 1) {
			return Math.min(A[startA], B[startB]);
		}
		int posA = Math.min(num / 2, m);
		int posB = num - posA;
		if (A[startA + posA - 1] == B[startB + posB - 1]) {
			return A[startA + posA - 1];
		} else if (A[startA + posA - 1] < B[startB + posB - 1]) {
			return findNum(A, B, startA + posA, endA, startB, endB, num - posA);
		} else {
			return findNum(A, B, startA, endA, startB + posB, endB, num - posB);
		}
	}

	public static void main(String[] args) {
		MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();

		System.out.println(m.findMedianSortedArrays(new int[] {2 },
				new int[] {}));
	}
}
