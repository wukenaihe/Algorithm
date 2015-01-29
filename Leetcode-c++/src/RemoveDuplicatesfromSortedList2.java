
public class RemoveDuplicatesfromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode p1=head,p2=head.next;
		while(p2!=null){
			if(p1.val==p2.val){
				p1.next=p2.next;
				p2=p2.next;
			}else{
				p1=p2;
				p2=p2.next;
			}
		}
		
		
		return head;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList2 r=new RemoveDuplicatesfromSortedList2();
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(2);
		l1.next=l2;
		l2.next=l3;
		
		ListNode l=r.deleteDuplicates(l1);
		
		System.out.println(l);
	}
}
