public class InsertionSortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode h=new ListNode(-1);
		h.next=head;
		ListNode p1=h;
		if(p1.next==null){
			return head;
		}
		ListNode p2=p1.next.next;
		p1.next.next=null;
		ListNode temp;
		while(p2!=null){
			p1=h;
			while(p1.next!=null&&p1.next.val<p2.val){
				p1=p1.next;
			}
			temp=p2;
			p2=p2.next;
			temp.next=p1.next;
			p1.next=temp;
		}
		
		return h.next;
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(4);
//		l1.next=l2;
//		l2.next=l3;
		InsertionSortList i=new InsertionSortList();
		ListNode r=i.insertionSortList(l1);
		i.print(r);
		
	}
	
	private void print(ListNode head){
		ListNode p=head;
		while(p!=null){
			System.out.print(p.val+" ");
			p=p.next;
		}
	}
	
}
