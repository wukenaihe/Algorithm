import java.util.ArrayList;
import java.util.List;

public class BST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list=new ArrayList<Integer>();
	
	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}
		search(root);
		
		int first=list.get(0);
		for(int i=1;i<list.size();++i){
			int second=list.get(i);
			if(second<=first){
				return false;
			}
			first=second;
		}
		return true;
	}
	
	private void search(TreeNode t){
		if(t.left!=null){
			search(t.left);
		}
		list.add(t.val);
		if(t.right!=null){
			search(t.right);
		}
	}
	
	public static void main(String[] args) {
		BST bst=new BST();
		
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(1);
//		TreeNode t3=new TreeNode(3);
		
		t1.left=t2;
//		t1.right=t3;
		
		System.out.println(bst.isValidBST(t1));
	}
}
