import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static class Node{
		TreeNode node;
		int level;
		
		public Node(TreeNode node,int level) {
			this.node=node;
			this.level=level;
		}
	}

	Queue<Node> q=new LinkedList<Node>();	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
		
		if(root==null){
			return list;
		}
		
		q.add(new Node(root, 0));
		
		int l=0;
		List<Integer> levelN=new ArrayList<Integer>();
		while(!q.isEmpty()){
			Node n=q.poll();
			if(n.level==l){
				levelN.add(n.node.val);
			}else{
				l=n.level;
				list.addFirst(levelN);
				levelN=new ArrayList<Integer>();
				levelN.add(n.node.val);
			}
			
			if(n.node.left!=null){
				q.add(new Node(n.node.left, n.level+1));
			}
			if(n.node.right!=null){
				q.add(new Node(n.node.right, n.level+1));
			}
			
		}
		list.addFirst(levelN);		
		
		return list;
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal2 b=new BinaryTreeLevelOrderTraversal2();
		
		TreeNode t1=new TreeNode(1);
		
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		
		t1.left=t2;
		t1.right=t3;
		
		System.out.println(b.levelOrderBottom(t1));
	}

}
