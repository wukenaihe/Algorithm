import java.util.Arrays;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int l1=A.length;
		int l2=B.length;
		if((l1+l2)%2==1){
			return findK(A, B, (l1+l2)/2+1);
		}else{
			return (findK(A,B,(l1+l2)/2)+findK(A, B, (l1+l2)/2+1))/2.0;
		}		
	}
	
	public double findK(int A[],int B[],int k){
		if (A.length == 0) return B[k - 1];
        if (B.length == 0) return A[k - 1];
        if (k == 1) return Math.min(A[0], B[0]);
        
        if(A.length>B.length) return findK(B, A, k);
        
        int pa=Math.min(k/2, A.length);
        int pb=k-pa;
        
        if(A[pa-1]<B[pb-1]){
        	return findK(Arrays.copyOfRange(A, pa, A.length), B, k-pa);
        }else if(A[pa-1]>B[pb-1]){
        	return findK(Arrays.copyOfRange(B, pb, B.length), A, k-pb);
        }else{
        	return A[pa-1];
        }        
	}
	
	public static void main(String[] args) {
		FindMedianSortedArrays f=new FindMedianSortedArrays();
		System.out.println(f.findMedianSortedArrays(new int[]{1}, new int[]{4}));
	}
}
