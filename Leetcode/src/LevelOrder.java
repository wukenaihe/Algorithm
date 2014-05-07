import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class LevelOrder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static class Node{
		TreeNode tree;
		int level;
		public Node(TreeNode node,int level){
			this.tree=node;
			this.level=level;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null){
			return result;
		}
		Deque<Node> q=new ArrayDeque<Node>();
		Node n=new Node(root, 1);
		q.addLast(n);
		int level=1;
		ArrayList<Integer> levelNode=new ArrayList<Integer>();
		result.add(levelNode);
		while(q.size()>0){
			Node temp=q.pollFirst();
			if(level==temp.level){
				levelNode.add(temp.tree.val);
			}else{
				levelNode=new ArrayList<Integer>();
				levelNode.add(temp.tree.val);
				result.add(levelNode);
				level=temp.level;
			}
			
			if(temp.tree.left!=null){
				Node newNode=new Node(temp.tree.left, temp.level+1);
				q.addLast(newNode);
			}
			if(temp.tree.right!=null){
				Node newNode=new Node(temp.tree.right, temp.level+1);
				q.addLast(newNode);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		root.left=n1;
		root.right=n2;
		
		TreeNode n3=new TreeNode(4);
		n2.right=n3;
		
		LevelOrder l=new LevelOrder();
		System.out.println(l.levelOrder(root));
	}
}
