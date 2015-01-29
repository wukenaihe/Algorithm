import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
//	Map<Integer, UndirectedGraphNode> map=new HashMap<Integer, CloneGraph.UndirectedGraphNode>();
//
//	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//		if(node==null){
//			return null;
//		}
//		int label=node.label;
//		UndirectedGraphNode c=map.get(label);
//		if(c!=null){
//			return c;
//		}else{
//			c=new UndirectedGraphNode(label);
//			c.neighbors=new ArrayList<UndirectedGraphNode>();
//			map.put(label, c);
//			ArrayList<UndirectedGraphNode> nodes=node.neighbors;
//			for (UndirectedGraphNode undirectedGraphNode : nodes) {
//				UndirectedGraphNode clone=cloneGraph(undirectedGraphNode);
//				c.neighbors.add(clone);
//			}
//		}
//		return c;
//	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<CloneGraph.UndirectedGraphNode, CloneGraph.UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode copyGraph=new UndirectedGraphNode(node.label);
        map.put(node, copyGraph);
        while(!queue.isEmpty()){
        	UndirectedGraphNode n=queue.poll();
        	UndirectedGraphNode c=map.get(n);
        	ArrayList<UndirectedGraphNode> neighbors=n.neighbors;
        	for (UndirectedGraphNode undirectedGraphNode : neighbors) {
				if(!map.containsKey(undirectedGraphNode)){
					queue.add(undirectedGraphNode);
					UndirectedGraphNode copy=new UndirectedGraphNode(undirectedGraphNode.label);
					map.put(undirectedGraphNode,copy);
					c.neighbors.add(copy);
				}else{
					c.neighbors.add(map.get(undirectedGraphNode));
				}
			}
        }
        return copyGraph;
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
