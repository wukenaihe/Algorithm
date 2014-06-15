
public class PrePostTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length);
	}

	private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder,
			int s2, int e2) {
		int length = e1 - s1+1;
		if (length <= 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[s1]);
		if(length==1){
			return root;
		}

		

		int i = s2;
		while (i <= e2 && inorder[i] != preorder[s1]) {
			i++;
		}

		if (s2 <= i - 1) {
			TreeNode left = buildTree(preorder, s1 + 1, s1 + i - s2, inorder,
					s2, i - 1);
			root.left = left;
		}

		if (i + 1 <= e2) {
			TreeNode right = buildTree(preorder, s1 + i - s2+1, e1, inorder,
					i + 1, e2);
			root.right = right;
		}

		return root;

	}

	public static void main(String[] args) {
		PrePostTree p = new PrePostTree();

		TreeNode tree = p.buildTree(new int[] { 1,2,4,5,3}, new int[] {4,2,5,1,3});

		System.out.println(tree);
	}
}
