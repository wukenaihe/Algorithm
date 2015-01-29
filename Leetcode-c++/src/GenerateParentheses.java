import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
	//卡特兰数
	List<String> list=new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		gen(n, n, "");
		return list;
	}
	
	private void gen(int left,int right,String s){
		if(left==0&&right==0){
			list.add(s);
		}
		
		if(left>0){
			gen(left-1,right,s+"(");
		}
		
		if(right>0&&left<right){
			gen(left, right-1, s+")");
		}
		
	}
	
	public static void main(String[] args) {
		GenerateParentheses g=new GenerateParentheses();
		List<String> list=g.generateParenthesis(4);
		Collections.sort(list);
		System.out.println(list);
	}
}
