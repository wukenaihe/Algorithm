import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		List<Integer> list=new ArrayList<Integer>();
		if(digits.length==0){
			return digits;
		}
		digits[digits.length-1]++;
		int i=digits.length-1;
		while(i>=0){
			int temp=digits[i];
			if(temp>9&&i>0){
				list.add(temp%10);
				digits[i-1]+=temp/10;
			}else if(temp>9&&i==0){
				list.add(temp%10);
				list.add(temp/10);
			}else{
				list.add(temp);
			}
			i--;
		}
		int[] A=new int[list.size()];
		i=A.length-1;
		for (int num : list) {
			A[i--]=num;
		}
		return A;
	}
	
	public static void main(String[] args) {
		PlusOne one=new PlusOne();
		
		int[] A=one.plusOne(new int[]{9,9,9});
		System.out.println(Arrays.toString(A));
	}
}
