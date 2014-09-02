import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0){
			return null;
		}
		ListNode head=new ListNode(0);
		ListNode cur=head;
		
		PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
			
		});
		
		for (ListNode listNode : lists) {
			if(listNode!=null){
				queue.add(listNode);
			}
		}		
		while(!queue.isEmpty()){
			ListNode l=queue.poll();
			if(l.next!=null){
				queue.add(l.next);
			}
			cur.next=l;
			cur=l;
		}
		cur.next=null;
		
		return head.next;
	}
	
	public static void main(String[] args) {
		MergeKLists m=new MergeKLists();
		
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		l3.next=l4;
		
		List<ListNode> list=new LinkedList<ListNode>();
		list.add(null);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		ListNode l=m.mergeKLists(list);
		ListNode.print(l);
	}
}
