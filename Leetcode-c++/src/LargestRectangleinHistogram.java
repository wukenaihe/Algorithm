import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack=new Stack<Integer>();
		int[] h=new int[height.length+1];
		System.arraycopy(height, 0, h, 0, height.length);
		int max=0;
		for(int i=0;i<=height.length;){
			if(stack.empty()||h[stack.peek()]<=h[i]){
				stack.push(i++);
			}else{
				int num=stack.pop();
				max=Math.max(max, h[num]*(stack.empty()?i:i-stack.peek()-1));
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LargestRectangleinHistogram l=new LargestRectangleinHistogram();
//		System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
		System.out.println(l.largestRectangleArea(new int[]{2,1,2}));
		System.out.println(l.largestRectangleArea(new int[]{4,2,0,3,2,5}));

	}
}
