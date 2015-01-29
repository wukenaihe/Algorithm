import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal2 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<Integer>();
        if(rowIndex==0){
        	list.add(1);
            return list;
        }
        Integer[] num=new Integer[rowIndex+1];
        num[0]=1;
        for(int i=1;i<=rowIndex;++i){
            int temp=num[0];
            for(int j=1;j<=i;++j){
                int res=0;
                if(j!=i){
                    res=temp+num[j];
                    temp=num[j];
                }else{
                    res=1;
                    temp=1;
                }
                num[j]=res;
            }
        }
        list.addAll(Arrays.asList(num));
        return list;
    }
	
	public static void main(String[] args) {
		Pascal2 p=new Pascal2();
		System.out.println(p.getRow(5));
	}
}
