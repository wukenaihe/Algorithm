import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> q=new LinkedList<Character>();
		int length=s.length();
		char last;
		if(length==0){
			return true;
		}
		q.push(s.charAt(0));
		for(int i=1;i<length;++i){
			char c=s.charAt(i);
			switch (c) {
			case '(':
			case '[':
			case '{':
				q.push(c);
				break;
			case ')':
				if(q.isEmpty()){
					return false;
				}
				last=q.pop();
				if(last!='('){
					return false;
				}
				break;
			case ']':
				if(q.isEmpty()){
					return false;
				}
				last=q.pop();
				if(last!='['){
					return false;
				}
				break;
			case '}':
				if(q.isEmpty()){
					return false;
				}
				last=q.pop();
				if(last!='{'){
					return false;
				}
				break;
			default:
				break;
			}
		}
		return q.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses v=new ValidParentheses();
		System.out.println(v.isValid("()"));
		System.out.println(v.isValid("()[]{}"));
		System.out.println(v.isValid("(]"));
		System.out.println(v.isValid("([)]"));
	}
}
