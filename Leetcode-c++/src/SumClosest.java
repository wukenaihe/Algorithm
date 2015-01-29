import java.util.Arrays;

public class SumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return 0;
		}
		Arrays.sort(num);
		int closet=Integer.MAX_VALUE;
		
		for(int i=0;i<num.length-2;++i){
			int cur=twoSum(num, i+1, target-num[i]);
			if(Math.abs(cur)<Math.abs(closet)){
				closet=cur;
			}
		}
		return target+closet;
	}
	
	private int twoSum(int[] num,int start,int target){
		int diff=Integer.MAX_VALUE;
		int l=start;
		int r=num.length-1;
		while(l<r){
			int closet=num[l]+num[r]-target;
			
			if(Math.abs(diff)>Math.abs(closet)){
				diff=closet;
			}
			if(num[l]+num[r]>target){
				r--;
			}else{
				l++;
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		SumClosest s=new SumClosest();
		System.out.println(s.threeSumClosest(new int[]{0,2,1,-3}, 1));
		System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
		System.out.println(s.threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82));
		System.out.println(s.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2));
	}
}
