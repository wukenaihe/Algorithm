
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		ListNode p=head;
		if(head==null||n==0){
			return head;
		}
		int length=1;
		while(p.next!=null){
			p=p.next;
			length++;
		}
		p.next=head;
		p=head;
		n=n%length;
		for(int i=1;i<length-n;++i){
			p=p.next;
		}
		head=p.next;
		p.next=null;
		
		return head;
	}
	
	public static void main(String[] args) {
		RotateList r=new RotateList();
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		
		ListNode l=r.rotateRight(l1, 2);
		System.out.println(l);
		
		
	}
}
