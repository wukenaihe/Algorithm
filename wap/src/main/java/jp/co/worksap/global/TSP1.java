package jp.co.worksap.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TSP1 {
	private int[][] distances;//距离矩阵，0为s,length-1为G
	private int length;
	private List<Map<Node, Integer>> stores=new ArrayList<Map<Node,Integer>>();
//	private Map<Node, Integer> store=new HashMap<Node, Integer>();//中间过程
	
	private int min;
	
	private static class Node{
		public List<Integer> points;

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((points == null) ? 0 : points.hashCode());
			return result;
		}
		
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			
			if(other.points.size()!=points.size()){
				return false;
			}
			List<Integer> first=new ArrayList<Integer>(points);
			first.removeAll(other.points);
			if(first.size()>0){
				return false;
			}
			return true;
		}
		
	}
	
	public TSP1(int[][] distance){
		this.distances=distance;
		this.length=distance.length;
	}
	
	public void guihua(){
		//S点出发去别的点
		Map<Node,Integer> store=new HashMap<Node, Integer>();
		for(int i=1;i<length-1;++i){
			Node n=new Node();
			List<Integer> list=new ArrayList<Integer>();
			list.add(i);
			n.points=list;
			store.put(n, distances[0][i]);
		}
		stores.add(store);
		
		//输入的个数
		for(int i=0;i<length-1;++i){
			Map<Node, Integer> old=stores.get(i);
			store=new HashMap<Node, Integer>();
			Set<Node> keys=old.keySet();
			for(int j=1;j<length-1;++j){
				for (Node node : keys) {
					List<Integer> p=node.points;
					if(p.contains(j)){
						continue;
					}
					int distance=old.get(node);
				}
			}
		}
	}
}
