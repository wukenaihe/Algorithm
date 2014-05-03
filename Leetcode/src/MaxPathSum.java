public class MaxPathSum {
	int max=0;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxPathSum(TreeNode root) {
		max=root.val;
		computePath(root);
		return max;
	}
	
	public int computePath(TreeNode root){
		if(root==null){
			return 0;
		}
		int a=computePath(root.left);
		int b=computePath(root.right);
		int result=root.val;
		if(a>0) result+=a;
		if(b>0)result+=b;
		if(result>max){
			max=result;
		}
		
		int max=a>=b?a:b;
		max=max>0?max:0;
		
		return root.val+max;
	}
	
	public static void main(String[] args) {
		MaxPathSum m=new MaxPathSum();
		TreeNode root=new TreeNode(9);
		TreeNode l=new TreeNode(6);
		TreeNode r=new TreeNode(-3);
		root.left=l;
		root.right=r;
		
		TreeNode l1=new TreeNode(-6);
		TreeNode r1=new TreeNode(2);
		r.left=l1;
		r.right=r1;
		
		TreeNode l2=new TreeNode(2);
		r1.left=l2;
		System.out.println(m.maxPathSum(root));
	}
}
