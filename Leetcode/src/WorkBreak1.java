import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkBreak1 {
	String[] dicts;
	boolean[][] result;
	Map<Integer, Boolean> record = new HashMap<Integer, Boolean>();

	public boolean wordBreak(String s, Set<String> dict) {
		int length = dict.size();
		int l2 = s.length();
		result = new boolean[length][s.length()];
		int i = 0;
		dicts = new String[dict.size()];
		for (String str : dict) {
			dicts[i++] = str;
		}
		parse(s);
		return has(0, s);
	}

	private boolean has(int start, String s) {
		if(record.get(start)!=null){
			return record.get(start);
		}
		int l1 = dicts.length;
		int l2 = s.length();
		if (start == l2 && start != 0) {
			return true;
		} else if (start > l2) {
			return false;
		}
		boolean ok=false;
		for (int i = 0; i < l1; ++i) {
			if (result[i][start]) {
				int other = start + dicts[i].length();
				boolean r = has(other, s);
				if(r){
					ok=true;
					break;
				}
			}
		}
		record.put(start, ok);
		return ok;
	}

	private void parse(String s) {
		for (int i = 0; i < dicts.length; ++i) {
			String str = dicts[i];
			for (int j = 0; j <= s.length() - str.length(); ++j) {
				boolean ok = true;
				for (int k = 0; k < str.length(); ++k) {
					if (s.charAt(k + j) != str.charAt(k)) {
						ok = false;
						break;
					}
				}
				result[i][j] = ok;
			}
		}
	}

	private void print() {
		for (int i = 0; i < result.length; i++) {
			System.out.print(dicts[i] + " ");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		WorkBreak1 wordBreak = new WorkBreak1();
		Set<String> dict = new HashSet<String>();
		Collections.addAll(dict, "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(s.length());
		boolean r = wordBreak.wordBreak(s, dict);
		System.out.println(r);
	}
}
