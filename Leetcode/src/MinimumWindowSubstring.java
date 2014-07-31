import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		Map<Character, Integer> need = new HashMap<Character, Integer>();
		Map<Character, Integer> has = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < T.length(); ++i) {
			char c = T.charAt(i);
			if (need.containsKey(c)) {
				int num = need.get(c);
				need.put(c, num + 1);
			} else {
				need.put(c, 1);
				has.put(c, 0);
			}
		}

		int minWinBegin = -1;
		int minWinEnd = S.length();

		for (int begin = 0, end = 0; end < S.length(); end++) {
			char c = S.charAt(end);
			if (need.containsKey(c)) {
				has.put(c, has.get(c) + 1);

				if (has.get(c) <= need.get(c)) {
					count++;
				}

				if (count == T.length()) {
					while (!need.containsKey(S.charAt(begin))
							|| has.get(S.charAt(begin)) > need.get(S
									.charAt(begin))) {
						if (need.containsKey(S.charAt(begin))
								&& has.get(S.charAt(begin)) > need.get(S
										.charAt(begin))) {
							has.put(S.charAt(begin),
									has.get(S.charAt(begin)) - 1);
						}
						begin++;
					}
					if (end - begin < minWinEnd - minWinBegin) {
						minWinEnd = end;
						minWinBegin = begin;
					}
				}
			}
		}

		return minWinBegin==-1?"":S.substring(minWinBegin,minWinEnd+1);
	}
	
	public static void main(String[] args) {
		MinimumWindowSubstring m=new MinimumWindowSubstring();
		
		System.out.println(m.minWindow("A", "AA"));
	}
}
