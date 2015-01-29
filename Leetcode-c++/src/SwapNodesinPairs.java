public class SwapNodesinPairs {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head==null){
			return head;
		}
		ListNode p1,p2,h,p;
		p1=head;
		p2=head.next;
		p=new ListNode(0);
		h=p;
		h.next=p1;
		while(p1!=null&&p2!=null){
			p1.next=p2.next;
			p.next=p2;
			p2.next=p1;
			p=p1;
			p1=p1.next;
			p2=p1!=null?p1.next:null;
		}
		
		return h.next;
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		SwapNodesinPairs s=new SwapNodesinPairs();
		print(s.swapPairs(l1));
	}
	
	private static void print(ListNode l){
		while(l!=null){
			System.out.print(l.val+"--");
			l=l.next;
		}
	}
}
