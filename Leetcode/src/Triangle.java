import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int length=triangle.size();
		int[] sum1=new int[length];
		int[] sum2=new int[length];
		sum1[0]=triangle.get(0).get(0);
		for(int i=1;i<length;++i){
			ArrayList<Integer> list=triangle.get(i);
			int l=list.size();
			sum2[0]=sum1[0]+list.get(0);
			for(int j=1;j<l-1;++j){
				sum2[j]=Math.min(sum1[j-1]+list.get(j), sum1[j]+list.get(j));
			}
			sum2[l-1]=sum1[l-2]+list.get(l-1);
			sum1=Arrays.copyOf(sum2, length);
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<length;++i){
			if(min>sum1[i]){
				min=sum1[i];
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		Triangle t=new Triangle();
		ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> l1=new ArrayList<Integer>();
		l1.add(2);
		triangle.add(l1);
		
		ArrayList<Integer> l2=new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		
		ArrayList<Integer> l3=new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		
		System.out.println(t.minimumTotal(triangle));
		
	}
}
