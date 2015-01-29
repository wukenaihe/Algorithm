import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		List<List<Integer>> r = combinationsSum(candidates, target, 0,
				new ArrayList<Integer>());
		result.addAll(r);
		return result;
	}

	private List<List<Integer>> combinationsSum(int[] candidates, int target,
			int start, List<Integer> path) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (target == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(path);
			result.add(list);
			return result;
		}

		for (int i = start; i < candidates.length; ++i) {
			if(i>start&&candidates[i]==candidates[i-1]) continue;
			int temp = target - candidates[i];
			if ( temp >= candidates[i] | temp == 0) {
				path.add(candidates[i]);
				List<List<Integer>> l = combinationsSum(candidates, temp, i+1, path);
				path.remove(path.size()-1);
				result.addAll(l);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		System.out.println(c.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(c.combinationSum(new int[] { 8,7,4,3 }, 11));
		System.out.println(c.combinationSum(new int[] { 10,1,2,7,6,1,5}, 8));

	}
}
