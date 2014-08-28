
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if(divisor==0){
		    return Integer.MAX_VALUE;
		}
		int res=0;
		if(dividend==Integer.MIN_VALUE){
		    res=1;
		    dividend+=Math.abs(divisor);
		}
		if(divisor==Integer.MIN_VALUE){
		    return res;
		}
		boolean isNeg=((dividend^divisor)>>>31)==1?true:false;
		
		dividend=Math.abs(dividend);
		divisor=Math.abs(divisor);
		
		int count=0;
		while(divisor<=(dividend>>1)){
		    count++;
		    divisor<<=1;
		}
		
		while(count>0){
		    if(dividend>=divisor){
		        dividend-=divisor;
		        res+=1<<count;
		    }
		    count--;
		    divisor>>=1;
		}
		
		return isNeg?-res:res;
    }
	
	public static void main(String[] args) {
		DivideTwoIntegers d=new DivideTwoIntegers();
		System.out.println(d.divide(-9, 4));
	}
}
