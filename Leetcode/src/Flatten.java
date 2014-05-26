public class Flatten {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if(root==null){
			return;
		}
		f(root);
	}
	
	public TreeNode f(TreeNode t){
		TreeNode n=t;
		TreeNode r=t.right;
		if(t.left!=null){
			n=f(t.left);
			t.right=t.left;
			t.left=null;
		}
		
		
		if(r!=null){
			TreeNode n1=f(r);
			n.right=r;
			n=n1;
		}
		return n;
	}
	
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		n1.left=n2;
//		n1.right=n5;
//		
//		n2.left=n3;
//		n2.right=n4;
//		
//		n5.right=n6;
		
		Flatten f=new Flatten();
		f.flatten(n1);
		print(n1);
	}
	
	public static void print(TreeNode n){
		while(n!=null){
			System.out.print(n.val+"--");
			n=n.right;
		}
	}
}
