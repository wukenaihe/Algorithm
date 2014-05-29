import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import jp.co.worksap.global.ArrayCopy;


public class Test {
	public static void main(String[] args) {
		Map<Integer, Node> map=new LinkedHashMap<Integer, Test.Node>();
		int num=11900000;
		for(int i=0;i<20;i++){
			test(num, map);
			num+=200000;
		}
		Set<Integer> set=map.keySet();
		for (Integer integer : set) {
			Node n=map.get(integer);
			System.out.println(n);
		}
	}
	
	public static class Node{
		public int num;
		public long original;
		public long parallel;
		public Node(int num,long original,long parallel){
			this.num=num;
			this.original=original;
			this.parallel=parallel;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", original=" + original
					+ ", parallel=" + parallel + "]";
		}
		
		
	}
	
	public static void test(int num,Map<Integer, Node> map){
		Integer[] b=new Integer[num];
		Random r=new Random();
		for(int i=0;i<b.length;++i){
			b[i]=r.nextInt();
		}
		long current=System.currentTimeMillis();
		Integer[] r1=new Integer[b.length];
		System.arraycopy(b, 0,r1 , 0, b.length);
		long original=System.currentTimeMillis()-current;
		
		current=System.currentTimeMillis();
		Integer[] r2=new Integer[b.length];
		ArrayCopy.copy(b, r2);
		long parallel=System.currentTimeMillis()-current;
		
		Node n=new Node(num, original, parallel);
		map.put(num, n);
		
		check(r1, r2);
	}
	
	public static void check(Integer[] r1,Integer[] r2){
		for(int i=0;i<r1.length;++i){
			if(r1[i]!=r2[i]){
				System.out.println(r1[i]+" "+r2[i]+"  "+i+"  length"+r1.length);
			}
		}
	}
}
