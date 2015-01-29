public class MinimumDepthBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int minD=Integer.MAX_VALUE;
	
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		minDepth(root, 1);
		return minD;
	}
	
	public void minDepth(TreeNode t,int d){
		if(t.left==null&&t.right==null){
			if(d<minD){
				minD=d;
			}
			return;
		}
		
		if(t.left!=null){
			minDepth(t.left, d+1);
		}
		
		if(t.right!=null){
			minDepth(t.right, d+1);
		}
	}
	
	public static void main(String[] args) {
		MinimumDepthBinaryTree m=new MinimumDepthBinaryTree();
		
		TreeNode t=new TreeNode(1);
		TreeNode t1=new TreeNode(2);
		t.left=t1;
		System.out.println(m.minDepth(t));
	}
}
