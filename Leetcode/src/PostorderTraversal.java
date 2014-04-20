import java.util.ArrayList;

public class PostorderTraversal {

	private ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		if(root==null){
			return list;
		}else{
			list.add(root.val);
			postorderTraversal(root.left);
			postorderTraversal(root.right);
		}
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		t1.right=t2;
		t2.left=t3;
		PostorderTraversal p=new PostorderTraversal();
		ArrayList<Integer> l=p.postorderTraversal(t1);
		System.out.println(l);
	}
}
