public class InPostTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}
		if (inorder.length == 1 && postorder.length == 1) {
			return new TreeNode(inorder[0]);
		}

		int i = 0;
		while (i < inorder.length && inorder[i] != postorder[postorder.length-1]) {
			i++;
		}

		TreeNode root = new TreeNode(inorder[i]);
		if (i - 1 >= 0) {
			TreeNode left = buildTree(copy(inorder, 0, i - 1),
					copy(postorder, 0, i - 1));
			root.left = left;
		}

		if (i + 1 <= inorder.length) {
			TreeNode right = buildTree(
					copy(inorder, i + 1, inorder.length - 1),
					copy(postorder, i, postorder.length - 2));
			root.right = right;
		}

		return root;

	}

	private int[] copy(int[] array, int start, int end) {
		int[] copyArray = new int[end - start + 1];
		int j = 0;
		for (int i = start; i <= end; ++i, ++j) {
			copyArray[j] = array[i];
		}

		return copyArray;
	}
	
	public static void main(String[] args) {
		InPostTree t=new InPostTree();
		
		TreeNode tree=t.buildTree(new int[]{4,2,5,1,3},new int[]{4,5,2,3,1});
		
		System.out.println(tree);
	}
}
