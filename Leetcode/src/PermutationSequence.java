public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		for (int i = 1; i <= n; ++i) {
			nums[i - 1] = i;
		}

		for (int i = 2; i <= k; ++i) {
			int change = 0;
			int j = n - 1;
			while (j > 0 && nums[j] < nums[j - 1]) {
				j--;
			}
			if (j == 0) {
				break;
			}
			change = j;

			while (change < n && nums[change] > nums[j - 1])
				change++;

			swap(nums, j - 1, change-1);
			int start = j;
			int end = n - 1;
			while (start < end) {
				swap(nums, start, end);
				start++;
				end--;
			}
		}

		return toStr(nums);
	}

	private String toStr(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; ++i) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		for (int i = 1; i <= 6; i++) {
			System.out.println(p.getPermutation(3, i));
		}
	}
}
