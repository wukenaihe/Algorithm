import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num.length - 2; ++i) {
			for (int j = i + 1; j < num.length - 1; ++j) {
				int temp = num[i] + num[j];
				for (int k = num.length-1; k >=j+1; --k) {
					if((temp+num[k])<0){
						break;
					}
					
					if ((temp + num[k]) == 0) {
						if(!has(list, num[i], num[j], num[k])){
							ArrayList<Integer> triplet = new ArrayList<Integer>(
									Arrays.asList(num[i], num[j], num[k]));
							list.add(triplet);
						}
						break;
					}
				}
			}
		}
		return list;
	}

	public boolean has(ArrayList<ArrayList<Integer>> list, int a, int b, int c) {
		if(list.size()==0){
			return false;
		}
		for(int i=list.size()-1;i>=0;--i){
			ArrayList<Integer> triplet = list.get(i);
			int a1=triplet.get(0);
			int b1=triplet.get(1);
			int c1=triplet.get(2);
			
			if(a1<a){
				return false;
			}
			
			if(a1==a&&b1==b&&c1==c){
				return true;
			}
		}

		return false;
	}

	private void print(List<ArrayList<Integer>> list) {
		for (ArrayList<Integer> l : list) {
			System.out.println(l);
		}
	}

	public static void main(String[] args) {
		Sum3 s = new Sum3();
		System.out.println(s.threeSum(new int[] { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6 }));
	}
}
