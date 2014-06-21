import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		if(s.length()==1){
			List<List<String>> list=new ArrayList<List<String>>();
			LinkedList<String> l=new LinkedList<String>();
			l.add(s);
			list.add(l);
			return list;
		}
		List<List<String>> result=new ArrayList<List<String>>();
		for(int i=1;i<s.length();++i){
			String sub=s.substring(0, i);
			if(isPalindrome(sub)){
				List<List<String>> r=partition(s.substring(i));
				for (List<String> list : r) {
					LinkedList<String> a=(LinkedList<String>) list;
					a.addFirst(sub);
					result.add(a);
				}
			}
		}
		if(isPalindrome(s)){
			List<String> l=new LinkedList<String>();
			l.add(s);
			result.add(l);
		}
		return result;
	}
	
	private boolean isPalindrome(String s){
		int l=s.length();
		int i=0,j=l-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning p=new PalindromePartitioning();
		
		System.out.println(p.partition("aa"));
	}
}
