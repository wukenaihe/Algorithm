import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> list=new ArrayList<Integer>();
		n=1<<n;
		for(int i=0;i<n;++i){
			int num=(i^(i>>1));
			list.add(num);
		}
		return list;
	}
	
	public static void main(String[] args) {
		GrayCode g=new GrayCode();
		List<Integer> list=g.grayCode(2);
		System.out.println(list);
	}
}
