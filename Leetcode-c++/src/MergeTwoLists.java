public class MergeTwoLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l=new ListNode(0);
		ListNode head=l;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				l.next=l1;
				l=l1;
				l1=l1.next;
			}else{
				l.next=l2;
				l=l2;
				l2=l2.next;
			}
		}
		if(l1!=null){
			l.next=l1;
		}else{
			l.next=l2;
		}
		return head.next;
	}
	private void print(ListNode list){
		while(list!=null){
			System.out.print(list.val+",");
			list=list.next;
		}
	}
	
	public static void main(String[] args) {
		MergeTwoLists m=new MergeTwoLists();
		ListNode l1=new ListNode(0);
//		l1.next=new ListNode(2);
		
		ListNode l2=new ListNode(1);
		
		m.print(m.mergeTwoLists(l1, l2));
	}
}
