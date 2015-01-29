
public class SymmetricTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		String l=left(root.left);
		String r=right(root.right);
		return l.equals(r);
	}
	
	public String left(TreeNode root){
		if(root==null){
			return "#";
		}
		String s=String.valueOf(root.val);
		
		String left=left(root.left);
		String right=left(root.right);
		return s+left+right;
	}
	
	public String right(TreeNode root){
		if(root==null){
			return "#";
		}
		String s=String.valueOf(root.val);
		String right=right(root.right);
		String left=right(root.left);
		return s+right+left;
	}
	
	
	public static void main(String[] args) {
		SymmetricTree s=new SymmetricTree();
		
		TreeNode t1=new TreeNode(0);
		TreeNode t2=new TreeNode(1);
		TreeNode t3=new TreeNode(1);
		TreeNode t4=new TreeNode(3);
		TreeNode t5=new TreeNode(3);
//		t2.right=t4;
//		t3.left=t5;
//		
		t1.left=t2;
		t1.right=t3;
		
		System.out.println(s.isSymmetric(t1));
	}
}
