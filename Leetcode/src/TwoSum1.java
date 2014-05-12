import java.util.Arrays;

public class TwoSum1 {
	
	public static class Node implements Comparable<Node>{
		public int value;
		public int index;
		
		public Node(int value,int index){
			this.value=value;
			this.index=index;
		}

		public int compareTo(Node o) {
			return value-o.value;
		}
	}
	
	public int[] twoSum(int[] numbers, int target) {
		Node[] nodes=new Node[numbers.length];
		for(int i=0;i<numbers.length;++i){
			nodes[i]=new Node(numbers[i], i+1);
		}
		Arrays.sort(nodes);
		int i=0,j=nodes.length-1;
		while(i<j){
			int num=nodes[i].value+nodes[j].value;
			if(num<target){
				i++;
			}else if(num>target){
				j--;
			}else{
				return new int[]{Math.min(nodes[i].index,nodes[j].index),Math.max(nodes[i].index,nodes[j].index)};
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TwoSum1 t=new TwoSum1();
		System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(t.twoSum(new int[]{5,75,25}, 100)));
	}
}
