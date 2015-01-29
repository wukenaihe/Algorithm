public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head;
		ListNode p = new ListNode(0);
		head = p;
		while (p1 != null && p2 != null) {
			int n1 = p1.val;
			int n2 = p2.val;
			int n = n1 + n2;
			if (n < 10) {
				p.next = new ListNode(n);
				p = p.next;
			} else {
				p.next = new ListNode(n % 10);
				p = p.next;

				n = n / 10;
				if (p1.next != null) {
					p1.next.val += n;
				} else if (p2.next != null) {
					p2.next.val += n;
				} else {
					p.next = new ListNode(n);
					p = p.next;
				}
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		ListNode q=null;
		q=p1==null?p2:p1;
		while(q!=null){
			if(q.val<10){
				p.next=q;
			}else{
				if(q.next==null){
					q.next=new ListNode(0);
				}
				q.next.val+=(q.val/10);
				q.val%=10;
			}
			p.next=q;
			p=q;
			q=q.next;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers a=new AddTwoNumbers();
		
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(4);
		ListNode l3=new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		
		ListNode p1=new ListNode(5);
		ListNode p2=new ListNode(6);
		ListNode p3=new ListNode(4);
		ListNode p4=new ListNode(1);
		p1.next=p2;
		p2.next=p3;
//		p3.next=p4;
		
		ListNode r=a.addTwoNumbers(l1, p1);
		a.print(r);
		
//		ListNode l1=new ListNode(1);
//		
//		ListNode p1=new ListNode(9);
//		ListNode p2=new ListNode(9);
//		p1.next=p2;
//		ListNode r=a.addTwoNumbers(l1, p1);
//		a.print(r);
		
	}
	
	private void print(ListNode l){
		while(l!=null){
			System.out.print(l.val+"--");
			l=l.next;
		}
	}
}
