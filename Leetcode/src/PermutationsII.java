import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		
		while(true){
			List<Integer> list=new ArrayList<Integer>();
			for (int i : num) {
				list.add(i);
			}			
			result.add(list);
			int p=num.length-1;
			while(p>0&&num[p]<=num[p-1]){
				p--;
			}
			if(p==0){
				return result;
			}
			//交换
			int change=p-1;
			while(p<num.length&&num[p]>num[change]){
				p++;
			}
			swap(num, change, p-1);
			p=num.length-1;
			change++;
			while(change<p){
				swap(num, change, p);
				change++;
				p--;
			}
			
		}		
	}
	
	private void swap(int[] num,int a,int b){
		int temp=num[a];
		num[a]=num[b];
		num[b]=temp;
	}
	
	public static void main(String[] args) {
		PermutationsII p=new PermutationsII();
		
		System.out.println(p.permuteUnique(new int[]{1,1,2,3}));
	}
}
