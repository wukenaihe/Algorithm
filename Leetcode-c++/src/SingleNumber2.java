public class SingleNumber2 {
	public int singleNumber(int A[]) {
		int[] count = new int[32];

		for (int i = 0; i < A.length; ++i) {
			int temp = A[i];
			for (int j = 0; j < 32; ++j) {
				if ((temp & 1) != 0) {
					count[j] = (count[j] + 1) % 3;
				}
				temp=temp>>1;
			}
		}
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			result |= count[i] << i;
		}

		return result;
	}
	
//	int singleNumber(int A[], int n) {
//	    int ones = 0, twos = 0, xthrees = 0;
//	    for(int i = 0; i < n; ++i) {
//	        twos |= (ones & A[i]);
//	        ones ^= A[i];
//	        xthrees = ~(ones & twos);
//	        ones &= xthrees;
//	        twos &= xthrees;
//	    }
//
//	    return ones;
//	}
	
	public static void main(String[] args) {
		int[] A=new int[]{3,3,3,2};
		SingleNumber2 s=new SingleNumber2();
		System.out.println(s.singleNumber(A));
	}
}
