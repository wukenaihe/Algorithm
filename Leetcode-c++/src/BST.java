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

	TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean l=isValidBST(root.left);
        if(pre!=null&&pre.val>=root.val)
        	return false;
        pre=root;
        return l&&isValidBST(root.right);
    }
	
	public static void main(String[] args) {
		BST bst=new BST();
		
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(1);
//		TreeNode t3=new TreeNode(3);
		
		t1.right=t2;
//		t1.right=t3;
		
		System.out.println(bst.isValidBST(t1));
	}
}
