import java.util.List;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode h=new ListNode(0);
		h.next=head;
		ListNode pm=head,pn,pre=h,temp;
		int i=1;
		while(i!=m){
			pre=pm;
			pm=pm.next;
			i++;
		}
		pn=pm.next;
		
		while(i!=n){
			temp=pn.next;
			pn.next=pm;
			pm=pn;
			pn=temp;
			i++;
		}
		pre.next.next=pn;
		pre.next=pm;
		
		return h.next;
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		
		ListNode l2=new ListNode(2);
		
		ListNode l3=new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		
		ReverseLinkedListII r=new ReverseLinkedListII();
		
		ListNode l=r.reverseBetween(l1, 1, 3);
		System.out.println(l);
	}
}
