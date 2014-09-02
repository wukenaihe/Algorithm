import java.util.Arrays;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        if(A==null||A.length==0){
            return 0;
        }
        
        int start=0,end=A.length-1;
        int count=A.length;
        
        while(start<=end){
            if(A[start]==elem){
                count--;
                swap(A,start,end--);
            }else{
                start++;
            }
        }
        return count;
    }
    
    private void swap(int[] A,int a,int b){
        A[a]=A[a]^A[b];
        A[b]=A[a]^A[b];
        A[a]=A[a]^A[b];
    }
	
	public static void main(String[] args) {
		RemoveElement r=new RemoveElement();
		int[] A=new int[]{1,2,1,3,4};
		System.out.println(r.removeElement(A, 1));
		System.out.println(Arrays.toString(A));
	}
	
	
}
