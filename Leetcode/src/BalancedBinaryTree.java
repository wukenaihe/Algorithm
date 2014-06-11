public class BalancedBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean result = true;

	public boolean isBalanced(TreeNode root) {
		depth(root);
		return result;
	}

	public int depth(TreeNode n) {
		if (n == null) {
			return 1;
		}
		int l = depth(n.left);
		int r = depth(n.right);

		if (l - r > 1 || l - r < -1) {
			result = false;
		}

		int max = Math.max(l, r);

		return max + 1;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);

		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.right = t3;

		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.println(b.isBalanced(t1));
	}
}
