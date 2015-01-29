public class InsertionSortList {


	public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode h=new ListNode(0);
        h.next=head;
        ListNode p=head.next,q,position;
        head.next=null;
        while(p!=null){
            q=p.next;
            position=h;
            while(position.next!=null&&position.next.val<p.val){
                position=position.next;
            }
            p.next=position.next;
            position.next=p;
            p=q;
        }
        return h.next;
    }
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		InsertionSortList i=new InsertionSortList();
		ListNode r=i.insertionSortList(l1);
		ListNode.print(r);
		
	}
}
