import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	Map<Integer, UndirectedGraphNode> map=new HashMap<Integer, CloneGraph.UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null){
			return null;
		}
		int label=node.label;
		UndirectedGraphNode c=map.get(label);
		if(c!=null){
			return c;
		}else{
			c=new UndirectedGraphNode(label);
			c.neighbors=new ArrayList<UndirectedGraphNode>();
			map.put(label, c);
			ArrayList<UndirectedGraphNode> nodes=node.neighbors;
			for (UndirectedGraphNode undirectedGraphNode : nodes) {
				UndirectedGraphNode clone=cloneGraph(undirectedGraphNode);
				c.neighbors.add(clone);
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode head=new UndirectedGraphNode(0);
		head.neighbors=new ArrayList<UndirectedGraphNode>();
		
		head.neighbors.add(new UndirectedGraphNode(1));
		head.neighbors.add(new UndirectedGraphNode(2));
		
		CloneGraph c=new CloneGraph();
		
		System.out.println(c.cloneGraph(head));
	}
}
