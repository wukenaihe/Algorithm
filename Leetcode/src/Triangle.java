import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null){
            return 0;
        }
        List<Integer> bottom=triangle.get(triangle.size()-1);
        int[] res=new int[bottom.size()];
        for(int i=0;i<bottom.size();++i){
            res[i]=bottom.get(i);
        }
        
        for(int i=triangle.size()-2;i>=0;--i){
            List<Integer> list=triangle.get(i);
            for(int j=0;j<list.size();++j){
                res[j]=Math.min(res[j],res[j+1])+list.get(j);
            }
        }
        return res[0];
    }
	
	public static void main(String[] args) {
		Triangle t=new Triangle();
		ArrayList<List<Integer>> triangle=new ArrayList<List<Integer>>();
		
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(2);
		triangle.add(l1);
		
		List<Integer> l2=new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		
		List<Integer> l3=new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		
		System.out.println(t.minimumTotal(triangle));
		
	}
}
