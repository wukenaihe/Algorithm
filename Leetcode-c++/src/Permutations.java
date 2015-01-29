import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		Arrays.sort(num);
		
		return permutes(num);
	}
	
	public List<List<Integer>> permutes(int[] num){
		int l=num.length;
		if(l==1){
			List<Integer> list=new ArrayList<Integer>();
			List<List<Integer>> result=new ArrayList<List<Integer>>();
			result.add(list);
			list.add(num[0]);
			return result;
		}
		List<List<Integer>> n=new ArrayList<List<Integer>>();
		
		int[] r=copy(num, 0);
		List<List<Integer>> result=permutes(r);
		
		for (List<Integer> list : result) {
			list.add(num[0]);
		}
		n.addAll(result);
		
		for(int i=1;i<l;++i){
			if(num[i]==num[i-1]){
				continue;
			}
			r=copy(num, i);
			result=permutes(r);
			
			for (List<Integer> list : result) {
				list.add(num[i]);
			}
			n.addAll(result);
		}
		return n;
	}
	
	private int[] copy(int[] num,int index){
		int l=num.length;
		int[] r=new int[l-1];
		int j=0;
		for(int i=0;i<l;++i){
			if(i!=index){
				r[j]=num[i];
				j++;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		Permutations p=new Permutations();
		
		System.out.println(p.permute(new int[]{1,1,3}));
	}
}
