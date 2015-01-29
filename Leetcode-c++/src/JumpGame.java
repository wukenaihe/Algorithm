public class JumpGame {
	public boolean canJump(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A.length <= 1)
			return true;
		if (A[0] >= (A.length - 1))
			return true;
		int maxlength = A[0];
		if (maxlength == 0)
			return false;
		for (int i = 1; i < A.length - 1; i++) {
			if (maxlength >= i && (i + A[i]) >= A.length - 1)
				return true;
			if (maxlength < i ||(maxlength==i&&A[i]==0))
				return false;
			if ((i + A[i]) > maxlength)
				maxlength = i + A[i];
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame j = new JumpGame();

		// System.out.println(j.canJump(new
		// int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
		// System.out.println(j.canJump(new int[]{2,3,1,1,4}));
		System.out.println(j.canJump(new int[] { 25000, 24999, 24998, 24997,
				24996, 24995, 24994, 24993 }));
	}
}
