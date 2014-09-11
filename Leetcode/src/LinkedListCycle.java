
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
