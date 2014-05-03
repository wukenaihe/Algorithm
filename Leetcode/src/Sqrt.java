public class Sqrt {
	public int sqrt(int x) {
//		return (int)Math.sqrt(x);
		
		
//		int start=0,end=x,mid=x/2;
//		while(start<=end){
//			int r=mid*mid;
//			if(r==x){
//				return mid;
//			}else if(r<x){
//				start=mid+1;
//			}else{
//				end=mid-1;
//			}
//			mid=(start+end)/2;
//		}
//		return 0;
		
		
		double x0 = x / 2.0;  
        double x1 = (x0 + x / x0) / 2.0;  
        while (Math.abs(x1 - x0) > 0.00001) {  
            x0 = x1;  
            x1 = (x0 + x / x0) / 2.0;  
        }  
        return (int) x1;  
	}
	
	public static void main(String[] args) {
		Sqrt s=new Sqrt();
		System.out.println(s.sqrt(2147395599));
	}
}
