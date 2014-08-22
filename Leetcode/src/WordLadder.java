import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	Map<String, Integer> map=new HashMap<String, Integer>();
	
	public int ladderLength(String start, String end, Set<String> dict) {
		for (String string : dict) {
			map.put(string, 0);
		}
		Queue<String> queue=new LinkedList<String>();
		queue.add(start);
		map.put(start, 1);
		while(!queue.isEmpty()){
			String s=queue.poll();
			Integer l=map.get(s);
			
			for(int i=0;i<s.length();++i){
				char[] stc=s.toCharArray();
				for(char j='a';j<='z';++j){
					stc[i]=j;
					String temp=new String(stc);
					if(temp.equals(end)){
						return l+1;
					}
					if(dict.contains(temp)&&map.get(temp)==0){
						map.put(temp, l+1);
						queue.add(temp);
					}
				}
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
