public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static void print(ListNode list){
		while(list!=null){
			System.out.print(list.val+"-");
			list=list.next;
		}
	}
	
	public String toString(){
		return String.valueOf(val);
	}
}
