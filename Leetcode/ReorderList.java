import com.sun.tools.classfile.Dependencies.Recorder;

public class ReorderList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode p1, p2, p3 = null, p4 = null;
		p1 = head;
		p2 = head;
		while (p2 != null && p2.next != null) {
			p3 = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}

		if (p2 == null) {
			p3.next = null;
			p2 = p1;
			p1 = head;
		} else {
			p2 = p1.next;
			p1.next = null;
			p1 = head;
		}
		p2=reverse(p2);
		
		while (p2 != null) {
			p3 = p1.next;
			p1.next = p2;
			p4 = p2.next;
			p2.next = p3;
			p2 = p4;
			p1 = p3;
		}
	}
	
	public ListNode reverse(ListNode p){
		if(p==null){
			return p;
		}
		ListNode p1=p,p2=p.next,p3;
		p1.next=null;
		while(p2!=null){
			p3=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p3;
		}
		
		return p1;
	}

	private void print(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ReorderList re = new ReorderList();
		re.reorderList(l1);

		re.print(l1);

	}
}
