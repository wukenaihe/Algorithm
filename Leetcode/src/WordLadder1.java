import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class WordLadder1 {

	public static class Node{
		int value;
		String s;
		public Node(int value,String s){
			this.value=value;
			this.s=s;
		}
	}
	
	public int ladderLength(String start, String end, Set<String> dict){
		dict.add(end);
		Deque<Node> nodes=new ArrayDeque<Node>(); 
		nodes.push(new Node(1, start));
		dict.remove(start);
		while(!nodes.isEmpty()){
			Node n=nodes.pop();
			Set<String> removes = new HashSet<String>();;
			for (String s : dict) {
				if(isBrother(n.s, s)){
					removes.add(s);
					nodes.push(new Node(n.value+1, s));
					if(s.equals(end)){
						return n.value+1;
					}
				}
			}
			dict.removeAll(removes);
		}
		return 0;
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

	public static void main(String[] args) {
		WordLadder1 w = new WordLadder1();
		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");

//		System.out.println(w.ladderLength("hit", "cog", dict));
		
//		Set<String> dict = new HashSet<String>();
//		dict.add("frye");
//		dict.add("heat");
//		dict.add("tree");
//		dict.add("thee");
//		dict.add("game");
//		dict.add("free");
//		dict.add("hell");
//		dict.add("fame");
//		dict.add("faye");
//
//		System.out.println(w.ladderLength("game", "thee", dict));
		
		dict.addAll(Arrays.asList(new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"}));
		System.out.println(w.ladderLength("qa", "sq", dict));
		
//		dict.addAll(Arrays.asList(new String[]{"a","b","c"}));
//		System.out.println(w.ladderLength("a", "b", dict));
	}
}
