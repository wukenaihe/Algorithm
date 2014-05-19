public class PathSum1 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return num(root, sum, 0);
	}
	
	public boolean num(TreeNode node,int sum,int num){
		if(node==null){
			return false;
		}
		if(node.left==null&&node.right==null){
			if(sum==num+node.val){
				return true;
			}else{
				return false;
			}
		}else{
			return num(node.left,sum,num+node.val)|num(node.right,sum,num+node.val);
		}
	}
	
	public static void main(String[] args) {
		TreeNode n=new TreeNode(5);
		TreeNode n1=new TreeNode(6);
		TreeNode n2=new TreeNode(7);
		n.left=n1;
		n.right=n2;
		PathSum1 p=new PathSum1();
		System.out.println(p.hasPathSum(n, 11));
	}
}
