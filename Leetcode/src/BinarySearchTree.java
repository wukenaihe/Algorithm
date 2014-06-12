import java.util.Arrays;

public class BinarySearchTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length==0){
			return null;
		}
		if(num.length==1){
			return new TreeNode(num[0]);
		}
		
		int first=num.length/2-1;
		int mid=num.length/2;
		TreeNode l=sortedArrayToBST(Arrays.copyOfRange(num, 0, first+1));
		TreeNode r=null;
		if(mid+1<=num.length){
			r=sortedArrayToBST(Arrays.copyOfRange(num,mid+1,num.length));
		}
		TreeNode t=new TreeNode(num[mid]);
		t.left=l;
		t.right=r;
		
		return t;
	}
	
	public static void main(String[] args) {
		BinarySearchTree b=new BinarySearchTree();
		
		TreeNode root=b.sortedArrayToBST(new int[]{3,2,1});
		System.out.println(root);
	}
}
