
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode h=new ListNode(0);
		ListNode p=h;
		ListNode p1=head,p2=head.next;
		while(p2!=null&&p2.next!=null){
			if(p1.val==p2.val){
				while(p2!=null&&p2.val==p1.val){
					p2=p2.next;
				}
				if(p2==null){
					p1=null;
					break;
				}else{
					p1=p2;
					p2=p2.next;
				}
			}else{
				h.next=p1;
				p1=p2;
				p2=p1.next;
				h=h.next;
			}
		}
		if(p2==null){
			h.next=p1;
		}else if(p1.val!=p2.val){
			h.next=p1;
			h=p1;
		}else{
			h.next=null;
		}
		
		
		
		return p.next;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList r=new RemoveDuplicatesfromSortedList();
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(1);
		ListNode l4=new ListNode(2);
		ListNode l5=new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		
		ListNode l=r.deleteDuplicates(l1);
		
		System.out.println(l);
	}
}
