
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode low=new ListNode(0);
		ListNode higher=new ListNode(0);
		
		ListNode l1=low,h1=higher;
		
		while(head!=null){
			if(head.val<x){
				l1.next=head;
				l1=head;
			}else{
				h1.next=head;
				h1=head;
			}
			head=head.next;
		}
		h1.next=null;
		if(low.next==null){
			return higher.next;
		}
		
		head=low.next;
		l1.next=higher.next;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		l1.next=l2;
		
		PartitionList p=new PartitionList();
		ListNode l=p.partition(l1, 1);
		
		System.out.println(l);
	}
}
