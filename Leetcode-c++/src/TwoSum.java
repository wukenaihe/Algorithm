import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSum {
	
	public static class Node implements Comparable<Node>{
		int val;
		int index;
		public Node(int val,int index){
			this.val=val;
			this.index=index;
		}
		
		public int compareTo(Node o) {
			return val-o.val;
		}
		
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int size=numbers.length;
		List<Node> list=new ArrayList<Node>();
		for(int i=0;i<size;++i){
			Node n=new Node(numbers[i], i+1);
			list.add(n);
		}
		
		Collections.sort(list);
		
		int[] result=new int[2];
		
		int start=0;
		int end=size-1;
		while(start<end){
			int num=list.get(start).val+list.get(end).val;
			if(num==target){
				int a=list.get(start).index;
				int b=list.get(end).index;
				result[0]=a<b?a:b;
				result[1]=a>b?a:b;
				return result;
			}else if(num<target){
				start++;
			}else{
				end--;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TwoSum t=new TwoSum();
		int[] r=t.twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(r));
	}
}
