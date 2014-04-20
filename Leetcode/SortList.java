import java.util.List;

public class SortList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode p2=half(head);
		ListNode first=sortList(head);
		ListNode second=sortList(p2);
		ListNode result=merageList(first, second);
		
		return result;

	}
	
	private ListNode half(ListNode head){
		ListNode p1=head;
		ListNode p2=head;
		ListNode p3;
		while(p2.next!=null&&p2.next.next!=null){
			p1=p1.next;
			p2=p2.next.next;
		}
		p3=p1.next;
		p1.next=null;
		return p3;
	}
		
	private ListNode merageList(ListNode l1,ListNode l2){
		ListNode head=new ListNode(0);
		ListNode point;
		ListNode p1;
		ListNode p2;
		p1=l1;
		p2=l2;
		point=head;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				point.next=p1;
				p1=p1.next;
			}else{
				point.next=p2;
				p2=p2.next;
			}
			point=point.next;
		}
		
		if(p1==null){
			point.next=p2;
		}else{
			point.next=p1;
		}
		
		
		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(5);
		ListNode l4=new ListNode(7);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		SortList s=new SortList();
		ListNode r=s.sortList(l1);
		s.print(r);
	}
	
	private void print(ListNode list){
		ListNode p=new ListNode(0);
		p.next=list;
		while(p!=null){
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
	}
}
