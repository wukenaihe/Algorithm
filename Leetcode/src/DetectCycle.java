public class DetectCycle {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}


	public boolean hasCycle(ListNode head) {
		ListNode p1=head;
		ListNode p2=head;
		while(p2!=null&&p2.next!=null){
			p1=p1.next;
			p2=p2.next.next;
			if(p1==p2&&p1!=null){
				return true;
			}
		}
		return false;
	}
}
