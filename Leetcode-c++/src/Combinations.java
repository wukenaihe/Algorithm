import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		if(n<k||n==0){
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> result=com(1,n,k);
		for (List<Integer> list : result) {
			Collections.reverse(list);
		}
		return result;
	}
	
	public List<List<Integer>> com(int start,int end,int k){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(k==1){
			for(int i=end;i>=start;--i){
				List<Integer> list=new ArrayList<Integer>();
				list.add(i);
				result.add(list);
			}
		}else{
			for(int i=end-k+1;i>=start;--i){
				List<List<Integer>> r=com(i+1, end, k-1);
				for (List<Integer> list : r) {
					list.add(i);
				}
				result.addAll(r);
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		Combinations c=new Combinations();
		List<List<Integer>> rs=c.combine(4, 2);
		System.out.println(rs);
	}
}
