
public class SortList {

	public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode end=head;
        int length=1;
        while(end.next!=null){
            end=end.next;
            length++;
        }
        
        return sortList(head,end,length);
    }
    
    private ListNode sortList(ListNode head,ListNode end,int length){
        if(length==1){
            end.next=null;
            return head;
        }
        
        int mid=length/2;
        ListNode endA=head;
        int i=0;
        while(i<mid-1){
            endA=endA.next;
            i++;
        }
        ListNode startB=endA.next;
        ListNode left=sortList(head,endA,mid);
        ListNode right=sortList(startB,end,length-mid);
        ListNode h=new ListNode(0);
        ListNode point=h;
        
        while(left!=null&&right!=null){
            if(left.val<right.val){
                point.next=left;
                left=left.next;
                point=point.next;
            }else{
                point.next=right;
                right=right.next;
                point=point.next;
            }
        }
        
        if(left==null){
            point.next=right;
        }else{
            point.next=left;
        }
        return h.next;
    }

	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(5);
		ListNode l4=new ListNode(7);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		SortList s=new SortList();
		ListNode r=s.sortList(l1);
		ListNode.print(r);
	}
	
}
