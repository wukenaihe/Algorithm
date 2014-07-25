import java.util.LinkedList;
import java.util.List;

public class MergeKLists {
//	public ListNode mergeKLists(List<ListNode> lists) {
//		ListNode l=null;
//		ListNode h=null;
//		while(lists.size()!=0){
//			ListNode p=null;
//			int min=Integer.MAX_VALUE;
//			int minIndex=0;
//			for (int i=0;i<lists.size();++i) {
//				ListNode listNode=lists.get(i);
//				if(listNode==null){
//					minIndex=i;
//					break;
//				}
//				if(listNode.val<min){
//					p=listNode;
//					min=listNode.val;
//					minIndex=i;
//				}
//			}
//			if(p==null){
//				lists.remove(minIndex);
//				continue;
//			}
//			if(l==null){
//				l=p;
//				h=p;
//			}else{
//				l.next=p;
//				l=p;
//			}
//			if (p.next==null) {
//				lists.remove(minIndex);
//			}else{
//				lists.set(minIndex, p.next);
//			}
//			
//			
//		}
//		return h;
//	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0){
			return null;
		}
		ListNode l=mergeKLists(lists, 0, lists.size()-1);
		return l;
	}
	
	public ListNode mergeKLists(List<ListNode> lists,int start,int end){
		if(start==end){
			return lists.get(start);
		}
		int mid=(start+end)/2;
		ListNode l1=mergeKLists(lists, start,mid);
		ListNode l2=mergeKLists(lists, mid+1, end);
		
		ListNode h=new ListNode(0);
		ListNode p=h;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				p.next=l1;
				l1=l1.next;
			}else{
				p.next=l2;
				l2=l2.next;
			}
			p=p.next;
		}
		
		if(l1!=null){
			p.next=l1;
		}
		
		if(l2!=null){
			p.next=l2;
		}
		
		return h.next;
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
		System.out.println(l);
		
		
	}
}
