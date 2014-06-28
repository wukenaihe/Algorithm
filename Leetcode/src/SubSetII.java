import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		sub(num, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	private void sub(int[] num,int start,List<Integer> temp,List<List<Integer>> result){
		List<Integer> arr=new ArrayList<Integer>(temp);
		result.add(arr);
		
		for(int i=start;i<num.length;++i){
			if(i!=start&&num[i]==num[i-1])continue;
			
			temp.add(num[i]);
			sub(num, i+1, temp, result);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		SubSetII s = new SubSetII();
		System.out.println(s.subsetsWithDup(new int[] { 4,1,0 }));
	}
}
