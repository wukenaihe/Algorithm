
public class RemoveNthNodeFromEndList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre=head;
		ListNode p=head;
		int count=0;
		for(;count<n;++count){
			pre=pre.next;
		}
		if(pre==null){
			return head.next;
		}
		while(pre.next!=null){
			pre=pre.next;
			p=p.next;
		}
		p.next=p.next.next;
		
		return head;
	}
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		
//		l1.next=l2;
//		l2.next=l3;
//		l3.next=l4;
//		l4.next=l5;
		
		RemoveNthNodeFromEndList r=new RemoveNthNodeFromEndList();
		ListNode l=r.removeNthFromEnd(l1, 1);
		System.out.println(l);
		
		
	}
}
