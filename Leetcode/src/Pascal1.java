import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal1 {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return list;
		list.add(new ArrayList<Integer>(Arrays.asList(1)));
		if(numRows==1)return list;
		list.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		if(numRows==2)return list;
		for(int i=2;i<numRows;++i){
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(1);
			for(int j=1;j<i;++j){
				int num=list.get(i-1).get(j-1)+list.get(i-1).get(j);
				temp.add(num);
			}
			temp.add(1);
			list.add(temp);
		}

		return list;
	}
	
	private void print(List<ArrayList<Integer>> list){
		for (List<Integer> arrayList : list) {
			for (Integer integer : arrayList) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Pascal1 p=new Pascal1();
		p.print(p.generate(5));
	}
}
