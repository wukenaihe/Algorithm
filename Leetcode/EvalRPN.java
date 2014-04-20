import java.util.Stack;

public class EvalRPN {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<tokens.length;++i){
			String str=tokens[i];
			if(str.equals("+")){
				int a=stack.pop();
				int b=stack.pop();
				stack.push(a+b);
			}else if(str.equals("-")){
				int a=stack.pop();
				int b=stack.pop();
				stack.push(b-a);
			}else if(str.equals("*")){
				int a=stack.pop();
				int b=stack.pop();
				stack.push(a*b);
			}else if(str.equals("/")){
				int a=stack.pop();
				int b=stack.pop();
				stack.push(b/a);
			}else{
				stack.push(Integer.valueOf(str));
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		EvalRPN e=new EvalRPN();
		int result=e.evalRPN(new String[]{"4", "13", "5", "/", "+"});
		System.out.println(result);
	}
}
