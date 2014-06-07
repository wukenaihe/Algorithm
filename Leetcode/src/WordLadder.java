import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

	public static class Node {
		public String value;
		public V next = null;

		public Node(String value) {
			this.value = value;
		}

	}

	public static class V {
		public V next = null;
		public Node n;

		public V(Node n) {
			this.n = n;
		}
	}

	LinkedHashMap<String, Node> map = new LinkedHashMap<String, Node>();
	List<String> list = new ArrayList<String>();

	public int ladderLength(String start, String end, Set<String> dict) {
		map.put(start, new Node(start));
		list.add(start);
		for (String string : dict) {
			map.put(string, new Node(string));
			list.add(string);
		}
		map.put(end, new Node(end));
		list.add(end);

		createGraph();

		return dj();
	}

	private void createGraph() {
		int length = list.size();
		for (int i = 0; i < length; ++i) {
			String s1 = list.get(i);
			Node t = map.get(s1);
			V p = null;
			for (int j = 0; j < length; ++j) {
				if (i != j && isBrother(s1, list.get(j))) {
					Node n = map.get(list.get(j));
					V v = new V(n);
					if (p == null) {
						t.next = v;
					} else {
						p.next = v;
					}
					p = v;
				}
			}
		}
	}

	private boolean isBrother(String s1, String s2) {
		int l = s1.length();
		int d = 0;
		for (int i = 0; i < l; ++i) {
			if (s1.charAt(i) != s2.charAt(i)) {
				d++;
				if (d > 1) {
					return false;
				}
			}
		}
		if (d == 1) {
			return true;
		} else {
			return false;
		}
	}

	private int dj() {
		Map<String, Integer> values = new HashMap<String, Integer>();
		String end = list.get(list.size() - 1);
		String start = list.get(0);
		int l = list.size();
		Deque<Node> nodes = new ArrayDeque<Node>();
		values.put(start, 1);
		V v1 = map.get(start).next;
		while (v1 != null) {
			nodes.push(v1.n);
			v1 = v1.next;
		}
		while (!nodes.isEmpty()) {
			Node n = nodes.pop();
			V v = n.next;
			int num = Integer.MAX_VALUE;
			while (v != null) {
				if (!values.containsKey(v.n.value)) {
					nodes.push(v.n);
					v = v.next;
					continue;
				}
				int distance = values.get(v.n.value);
				if (distance < num) {
					num = distance;
				}
				v = v.next;
			}
			if (n.value.equals(end)) {
				if (num != Integer.MAX_VALUE) {
					return num + 1;
				} else {
					return 0;
				}
			} else {
				values.put(n.value, num + 1);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		System.out.println(w.ladderLength("hit", "cog", dict));
	}
}
