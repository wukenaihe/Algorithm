import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		int l = S.length;
		Arrays.sort(S);
		int[] s = new int[l];
		int j = l - 1;
		for (int i = 0; i < l; ++i) {
			s[j] = S[i];
			j--;
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 1; i <= l; ++i) {
			List<List<Integer>> sub = sub(s, 0, i);
			result.addAll(sub);
		}
		return result;
	}

	public List<List<Integer>> sub(int[] s, int start, int num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == 1) {
			for (int i = start; i < s.length; ++i) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(s[i]);
				result.add(list);
			}
			return result;
		}
		for (int i = start; i < s.length - num + 1; ++i) {
			List<List<Integer>> l = sub(s, i + 1, num - 1);
			for (List<Integer> list : l) {
				list.add(s[i]);
			}
			result.addAll(l);
		}
		return result;
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
	}
}
