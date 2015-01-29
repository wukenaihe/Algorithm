import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static class Node {
		TreeNode val;
		int level;

		public Node(TreeNode t, int level) {
			this.val = t;
			this.level = level;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null) {
			return result;
		}
		boolean reverse = false;
		queue.add(new Node(root, 0));
		int currentLevel = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.level == currentLevel) {
				list.add(n.val.val);
			} else {
				if (reverse) {
					Collections.reverse(list);
					reverse = false;
				} else {
					reverse = true;
				}
				result.add(list);
				list = new ArrayList<Integer>();
				list.add(n.val.val);
				currentLevel = n.level;
			}

			if (n.val.left != null) {
				queue.add(new Node(n.val.left, n.level + 1));
			}

			if (n.val.right != null) {
				queue.add(new Node(n.val.right, n.level + 1));
			}
		}
		if (reverse) {
			Collections.reverse(list);
		} 
		result.add(list);

		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal b=new BinaryTreeZigzagLevelOrderTraversal();
		
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		t1.left=t2;
		t1.right=t3;
		
		System.out.println(b.zigzagLevelOrder(t1));
	}
}
