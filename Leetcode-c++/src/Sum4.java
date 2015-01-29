import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; ++i) {
			if(i!=0&&num[i]==num[i-1]){
				continue;
			}
			for (int j = i + 1; j < num.length - 2; ++j) {
				if(j!=i+1&&num[j]==num[j-1]){
					continue;
				}
				int k = j + 1, l = num.length - 1;
				int t = target - num[i] - num[j];
				while (k < l) {
					int temp = num[k] + num[l];
					if (t == temp) {
						List<Integer> r = new ArrayList<Integer>();
						r.add(num[i]);
						r.add(num[j]);
						r.add(num[k]);
						r.add(num[l]);
						list.add(r);
						while (k+1 <num.length && num[k] == num[k + 1]) {
							k++;
						}
						while (l-1>=0 && num[l] == num[l - 1]) {
							l--;
						}
						k++;
						l--;

					} else if (t > temp) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Sum4 sum = new Sum4();
		System.out.println(sum.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(sum.fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 },
				0).size());
		System.out.println(sum.fourSum(new int[] { 0,0,0,0 },
				0));

	}

}
