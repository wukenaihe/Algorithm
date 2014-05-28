import java.util.Arrays;
import java.util.Random;

import com.xumh.collections.ArrayCopy;


public class Test {
	public static void main(String[] args) {
		Integer[] b=new Integer[100001];
		Random r=new Random();
		for(int i=0;i<b.length;++i){
			b[i]=r.nextInt();
		}
		long current=System.currentTimeMillis();
		Integer[] r1=new Integer[b.length+1];
		System.arraycopy(b, 0,r1 , 0, b.length);
		System.out.println(System.currentTimeMillis()-current);
		
		current=System.currentTimeMillis();
		Integer[] r2=new Integer[b.length+1];
		ArrayCopy.copy(b, r2);
		System.out.println(System.currentTimeMillis()-current);
		
		for(int i=0;i<b.length;++i){
			if(r1[i]!=r2[i]){
				System.out.println(r1[i]+" "+r2[i]+"  "+i);
			}
		}
		
	}
}
