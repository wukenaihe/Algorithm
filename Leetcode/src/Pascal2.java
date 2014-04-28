import java.util.ArrayList;

public class Pascal2 {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list=new ArrayList<Integer>(rowIndex);
		list.add(1);
		if(rowIndex==0) return list;
		list.add(1);
		if(rowIndex==1) return list;
		
		for(int i=2;i<=rowIndex;++i){
			int temp=list.get(0)+list.get(1);
			for(int j=2;j<i;++j){
				int num=list.get(j-1)+list.get(j);
				list.set(j-1, temp);
				temp=num;
			}
			list.set(i-1, temp);
			list.add(1);
		}
		
		
		return list;
	}
	
	public static void main(String[] args) {
		Pascal2 p=new Pascal2();
		System.out.println(p.getRow(0));
	}
}
