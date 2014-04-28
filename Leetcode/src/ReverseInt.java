import java.util.List;
import java.util.Stack;

public class ReverseInt {
	public int reverse(int x) {
		Stack<Integer> stack=new Stack<Integer>();
		boolean negative=x<0?true:false;
		x=Math.abs(x);
		
		while(x!=0){
			int a=x%10;
			stack.push(a);
			x=x/10;
		}
		int b=1,sum=0;
		while(!stack.isEmpty()){
			sum+=stack.pop()*b;
			b*=10;
		}
		if(negative){
			return -sum;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ReverseInt r=new ReverseInt();
		System.out.println(r.reverse(123));
	}
}
