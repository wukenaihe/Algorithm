import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree2 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list=new ArrayList<Integer>();
		while(head!=null){
			list.add(head.val);
			head=head.next;
		}
		int length=list.size();
		int[] num=new int[length];
		for(int i=0;i<length;++i){
			num[i]=list.get(i);
		}
		return sortedArrayToBST(num);
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length==0){
			return null;
		}
		if(num.length==1){
			return new TreeNode(num[0]);
		}
		
		int first=num.length/2-1;
		int mid=num.length/2;
		TreeNode l=sortedArrayToBST(Arrays.copyOfRange(num, 0, first+1));
		TreeNode r=null;
		if(mid+1<=num.length){
			r=sortedArrayToBST(Arrays.copyOfRange(num,mid+1,num.length));
		}
		TreeNode t=new TreeNode(num[mid]);
		t.left=l;
		t.right=r;
		
		return t;
	}
}
