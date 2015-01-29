import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix){
		int l1=matrix.length;
		if(l1==0){
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int l2=matrix[0].length;
		for(int i=0;i<l1;++i){
			int[] height=new int[l2+1];
			for(int j=0;j<l2;++j){
				int h=0;
				for(int k=i;k>=0;--k){
					if(matrix[k][j]=='1'){
						h++;
					}else{
						height[j]=h;
						break;
					}
					
					if(k==0){
						height[j]=h;
					}
				}
			}
			max=Math.max(max, maxArea(height));
		}
		return max;
	}
	
	private int maxArea(int[] height){
		Stack<Integer> stack=new Stack<Integer>();
		int max=0;
		int i=0;
		while(i<height.length){
			if(stack.isEmpty()||height[i]>=height[stack.peek()]){
				stack.push(i++);
			}else{
				int h=stack.pop();
				max=Math.max(max, height[h]*(stack.isEmpty()?i:i-stack.peek()-1));
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximalRectangle m=new MaximalRectangle();
		
		System.out.println(m.maximalRectangle(new char[][]{{'0','0','0'},{'1','1','1'},{'0','1','1'}}));
		System.out.println(m.maximalRectangle(new char[][]{{'0','0','0'},{'0','1','1'},{'0','0','1'}}));
		System.out.println(m.maximalRectangle(new char[][]{{'0','1'},{'0','1'}}));


	}
	

}
