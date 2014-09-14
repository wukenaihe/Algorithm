public class Connect2 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode nextHead=root;
        TreeLinkNode cur=null;
        TreeLinkNode pre = null;
        while(nextHead!=null){
            cur=nextHead;
            nextHead=null;
            while(cur!=null){
                if(cur.left!=null){
                    if(nextHead==null){
                        nextHead=cur.left;
                        pre=cur.left;
                    }else{
                        pre.next=cur.left;
                        pre=cur.left;
                    }
                }
                if(cur.right!=null){
                    if(nextHead==null){
                        nextHead=cur.right;
                        pre=cur.right;
                    }else{
                        pre.next=cur.right;
                        pre=cur.right;
                    }
                }
                cur=cur.next;
            }
        }

    }

	public static void main(String[] args) {
		Connect2 c = new Connect2();

		TreeLinkNode n1 = new TreeLinkNode(1);

		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		n1.left = n2;
		n1.right = n3;

		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);

		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n5;

		c.connect(n1);

		System.out.println(n1);
	}

}
