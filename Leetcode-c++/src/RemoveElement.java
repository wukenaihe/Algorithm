import java.util.Arrays;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int length=A.length;
		int l=length;
		int head=0,p=0;
		while(p<l){
			while(p<l&&A[p]==elem){
				p++;
				length--;
			}
			
			if(p<l&&head<p){
				A[head]=A[p];
			}
			head++;
			p++;
		}
		
		return length;
	}
	
	public static void main(String[] args) {
		RemoveElement r=new RemoveElement();
		int[] A=new int[]{1,2,1};
		System.out.println(r.removeElement(A, 1));
		System.out.println(Arrays.toString(A));
	}
	
	
}
