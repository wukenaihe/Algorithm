
public class RemoveNthNodeFromEndList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode pre=head,end=head;
        for(int i=0;i<n&&end!=null;++i){
            end=end.next;
        }
        if(end==null){
            return head.next;
        }
        while(end.next!=null){
            end=end.next;
            pre=pre.next;
        }
        
        pre.next=pre.next.next;
        return head;
        
    }
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		
		RemoveNthNodeFromEndList r=new RemoveNthNodeFromEndList();
		ListNode l=r.removeNthFromEnd(l1, 2);
		ListNode.print(l);
		
		
	}
}
