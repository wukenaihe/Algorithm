import java.util.ArrayList;
import java.util.List;


public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		num1=num1.charAt(0)=='+'?num1.substring(1):num1;
		num2=num2.charAt(0)=='+'?num2.substring(1):num2;
		if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
			return "0";
		}
		List<Integer> num1s=parse(num1);
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<num2.length();++i){
			int b=num2.charAt(i)-'0';
			for(int j=0;j<num1s.size();++j){
				int temp=b*num1s.get(j);
				if(j+i>=result.size()){
					result.add(temp);
				}else{
					result.set(j+i, result.get(j+i)+temp);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		int p=0;
		while(p<result.size()){
			sb.append(result.get(p)%10);
			int n=result.get(p)/10;
			if(n>0&&p+1>=result.size()){
				result.add(n);
			}else if(n>0){
				result.set(p+1, n+result.get(p+1));
			}
			p++;
		}
		
		return sb.reverse().toString();
	}
	
	private List<Integer> parse(String num){
		int i=num.length()-1;
		List<Integer> nums=new ArrayList<Integer>();
		while(i>=0){
			nums.add(num.charAt(i--)-'0');
		}
		return nums;
	}
	
	public static void main(String[] args) {
		MultiplyStrings m=new MultiplyStrings();
		System.out.println(m.multiply("+11", "+11"));
	}
}
