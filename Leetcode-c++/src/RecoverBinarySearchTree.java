public class RecoverBinarySearchTree {
	TreeNode error1, error2,pre;

	public void recoverTree(TreeNode root) {
		if(root==null){
			return;
		}
		find(root);
		int temp=error1.val;
		error1.val=error2.val;
		error2.val=temp;
	}
	
	public void find(TreeNode root){
		if(root==null){
			return;
		}
		find(root.left);
		
		if(pre!=null&&pre.val>root.val){
			if(error1==null){
				error1=pre;
				error2=root;
			}else{
				error2=root;
			}
		}
		
		pre=root;
		find(root.right);
	}

}
