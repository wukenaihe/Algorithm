public class SumNumbers {
	int sum=0;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if(root==null){
			return 0;
		}
		sum(root,0);
		return sum;
	}
	
	public void sum(TreeNode node,int num){
		int temp=num*10+node.val;
		if(node.left==null&&node.right==null){
			sum+=temp;
			return;
		}
		
		
		if(node.left!=null){
			sum(node.left,temp);
		}
		
		if(node.right!=null){
			sum(node.right,temp);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode t=new TreeNode(1);
		TreeNode l1=new TreeNode(2);
		TreeNode l2=new TreeNode(3);
		t.left=l1;
		t.right=l2;
		
		SumNumbers s=new SumNumbers();
		System.out.println(s.sumNumbers(t));
	}
}
