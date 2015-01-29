import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for(String s:tokens){
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(s.equals("-")){
            	int right=stack.pop();
            	int left=stack.pop();
                stack.push(left-right);
            }else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(s.equals("/")){
            	int right=stack.pop();
            	int left=stack.pop();
                stack.push(left/right);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		EvaluateReversePolishNotation e=new EvaluateReversePolishNotation();
		
		int result=e.evalRPN(new String[]{"4", "13", "5", "/", "+"});
		System.out.println(result);
	}
}
