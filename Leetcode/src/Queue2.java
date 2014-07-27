public class Queue2 {

	int total = 0;

	public int totalNQueens(int n) {
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = i + 1;
		}
		isOk(nums, 0, new int[n]);
		return total;
	}

	private void isOk(int[] nums,int start,int[] pre){
//		if(start==nums.length-1){
//			pre[start]=nums[start];
//			
//			for(int i=0;i<start;++i){
//				if(Math.abs(i-start)==Math.abs(pre[i]-nums[start])){
//					break;
//				}
//			}
//			
//			total++;
//			pre[start]=0;
//			return;
//		}
//		for(int i=start;i<nums.length;++i){
//			for(int j=0;j<start;++j){
//				boolean ok=true;
//				if(Math.abs(j-start)==Math.abs(pre[j]-nums[start])){
//					ok=false;
//					break;
//				}
//				if(!ok){
//					break;
//				}
//			}
//			int temp=nums[start];
//			nums[start]=nums[i];
//			nums[i]=temp;
//			pre[start]=nums[start];
//			isOk(nums, start+1, pre);
//			temp=nums[start];
//			nums[start]=nums[i];
//			nums[i]=temp;
//		}
	}

	public static void main(String[] args) {
		Queue2 q = new Queue2();
		System.out.println(q.totalNQueens(8));
	}

}
