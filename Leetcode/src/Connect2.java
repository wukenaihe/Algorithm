public class Connect2 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode l = root;
		TreeLinkNode p = root;
		TreeLinkNode n = null;
		while (true) {
			while (p != null) {
				if (p.left != null) {
					if (p.right != null) {
						p.left.next = p.right;
					} else {
						n = p.next;
						while (n != null) {
							if (n.left != null) {
								p.left.next = n.left;
								break;
							} else if (n.right != null) {
								p.left.next = n.right;
								break;
							}
							n = n.next;
						}
					}
				}

				if (p.right != null) {
					n = p.next;
					while (n != null) {
						if (n.left != null) {
							p.right.next = n.left;
							break;
						} else if (n.right != null) {
							p.right.next = n.right;
							break;
						}
						n = n.next;
					}
				}
				p = p.next;
			}

			p = nextLeft(l);
			if (p == null) {
				return;
			}
			l = p;
			n = p;
		}
	}

	public TreeLinkNode nextLeft(TreeLinkNode n) {

		while (n != null) {
			if (n.left != null) {
				return n.left;
			} else if (n.right != null) {
				return n.right;
			} else {
				n = n.next;
			}
		}
		return null;
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
//		n2.right = n5;
//		n3.left = n6;
		n3.right = n5;

		c.connect(n1);

		System.out.println(n1);
	}

}
