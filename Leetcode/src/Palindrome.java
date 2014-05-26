import java.util.ArrayList;
import java.util.List;


public class Palindrome {
	public boolean isPalindrome(String s) {
		int start=0;
		List<Character> list=handle(s);
		int end=list.size()-1;
		while(start<end){
			if(list.get(start)!=list.get(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public List<Character> handle(String s){
		List<Character> list=new ArrayList<Character>();
		int l=s.length();
		
		for(int i=0;i<l;++i){
			Character c=s.charAt(i);
			if(c<='z'&&c>='a'){
				list.add(c);
			}else if(c<='Z'&&c>='A'){
				c=Character.toLowerCase(c);
				list.add(c);
			}else if(c<='9'&&c>='0'){
				list.add(c);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Palindrome p=new Palindrome();
		
//		System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(p.isPalindrome("race a car"));
		System.out.println(p.isPalindrome("1a2"));
	}
}
