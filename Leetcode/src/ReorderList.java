
public class ReorderList {
	public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode nextHead=slow.next;
        slow.next=null;
        
        nextHead=reverse(nextHead);
        ListNode p=head;
        slow=head;
        fast=nextHead;
        while(slow!=null&&fast!=null){
            ListNode s=slow.next;
            slow.next=fast;
            ListNode f=fast.next;
            fast.next=s;
            slow=s;
            fast=f;
        }
        
    }
    
    private ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre=null,p=head;
        while(p!=null){
            ListNode temp=p.next;
            p.next=pre;
            pre=p;
            p=temp;
        }
        return pre;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ReorderList re = new ReorderList();
		re.reorderList(l1);

		ListNode.print(l1);

	}
}
