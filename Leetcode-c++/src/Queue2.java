
public class Queue2 {
	public int totalNQueens(int n) {
		int[] nums = new int[n];
		int count = 0;
		for (int i = 0; i < n; ++i) {
			nums[i] = i;
		}
		while (true) {
			if(ok(nums)){
				count++;
			}
			int i = nums.length - 1;
			while (i > 0 && nums[i - 1] > nums[i]) {
				i--;
			}
			if(i<=0){
				return count;
			}
			int q = i - 1;
			while (i < nums.length && nums[i] > nums[q]) {
				i++;
			}
			swap(nums, q, i-1);
			q += 1;
			i = nums.length - 1;
			while (q < i) {
				swap(nums, q++, i--);
			}
		}
	}

	private boolean ok(int[] nums) {
		for(int i=0;i<nums.length-1;++i){
			for(int j=i+1;j<nums.length;++j){
				if((j-i)==Math.abs(nums[i]-nums[j])){
					return false;
				}
			}
		}
		return true;

	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		Queue2 q = new Queue2();
		System.out.println(q.totalNQueens(4));
	}

}
