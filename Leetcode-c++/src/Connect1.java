import java.util.Deque;
import java.util.LinkedList;

public class Connect1 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

//	public static class Node {
//		public TreeLinkNode n;
//		public int level;
//
//		public Node(TreeLinkNode n, int level) {
//			this.n = n;
//			this.level = level;
//		}
//	}
//
//	public void connect(TreeLinkNode root) {
//		if(root==null){
//			return;
//		}
//		Deque<Node> q=new LinkedList<Node>();
//		
//		q.add(new Node(root, 1));
//		int l=0;
//		TreeLinkNode p = null;
//		while(!q.isEmpty()){
//			Node n=q.poll();
//			
//			if(l!=n.level){
//				p=n.n;
//				l=n.level;
//			}else{
//				p.next=n.n;
//				p=n.n;
//			}
//			
//			
//			
//			if(n.n.left!=null){
//				q.add(new Node(n.n.left, n.level+1));
//			}
//			if(n.n.right!=null){
//				q.add(new Node(n.n.right, n.level+1));
//			}
//		}
//	}
	public void connect(TreeLinkNode root){
		TreeLinkNode t=root,leftWall=root;
		
		while(leftWall!=null){
			t=leftWall;
			while(t!=null){
				if(t.left!=null){
					t.left.next=t.right;
				}
				
				if(t.right!=null&&t.next!=null){
					t.right.next=t.next.left;
				}
				t=t.next;
			}
			leftWall=leftWall.left;
		}
	}
	
	public static void main(String[] args) {
		Connect1 c=new Connect1();
		
		TreeLinkNode n1=new TreeLinkNode(1);
		
		TreeLinkNode n2=new TreeLinkNode(2);
		TreeLinkNode n3=new TreeLinkNode(3);
		n1.left=n2;
		n1.right=n3;
		
		TreeLinkNode n4=new TreeLinkNode(4);
		TreeLinkNode n5=new TreeLinkNode(5);
		TreeLinkNode n6=new TreeLinkNode(6);
		TreeLinkNode n7=new TreeLinkNode(7);
		
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
		
		c.connect(n1);
		
		System.out.println(n1);
	}
}
