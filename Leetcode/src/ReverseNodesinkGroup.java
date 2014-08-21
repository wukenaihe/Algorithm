import java.util.List;

public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null||k==1){
			return head;
		}
		ListNode h=new ListNode(0);
		h.next=head;
		
		ListNode start=h;
		ListNode end=h;
		int count=0;
		while(end!=null){
			end=end.next;
			count++;
			if(count==k+1){
				start=reverse(start, end);
				end=start;
				count=0;
			}
		}
		return h.next;
	}
	
	private ListNode reverse(ListNode start,ListNode end){
		ListNode p1=start.next;
		ListNode p2=p1.next;
		ListNode p3;
		while(p2!=end){
			p3=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p3;
		}
		p3=start.next;
		start.next.next=end;
		start.next=p1;
		return p3;
	}
	
	private static void print(ListNode l){
		while(l!=null){
			System.out.print(l.val+"->");
			l=l.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		
		ReverseNodesinkGroup r=new ReverseNodesinkGroup();
		ListNode l=r.reverseKGroup(l1, 4);
		print(l);
	}
}
