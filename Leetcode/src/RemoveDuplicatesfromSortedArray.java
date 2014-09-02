import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        
        int start=0;
        for(int i=1;i<A.length;++i){
            if(A[i]!=A[i-1]){
                A[++start]=A[i];
            }
        }
        return start+1;
        
    }

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		int[] A = new int[] { -1,0,0,3,3,4};
		System.out.println(r.removeDuplicates(A));
		System.out.println(Arrays.toString(A));
	}
}
