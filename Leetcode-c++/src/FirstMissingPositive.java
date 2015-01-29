public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int i=0,length=A.length;
		while(i<length){
			if(A[i]!=i+1&&A[i]>=1&&A[i]<=length&&A[A[i]-1]!=A[i]){
				swap(A, i, A[i]-1);
			}else{
				i++;
			}
		}
		
		for(i=0;i<length;++i){
			if(A[i]!=i+1){
				return i+1;
			}
		}
		return length+1;
	}
	
	private void swap(int[] A,int a,int b){
		int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
	}
	public static void main(String[] args) {
		FirstMissingPositive f=new FirstMissingPositive();
		
		System.out.println(f.firstMissingPositive(new int[]{1,2,0}));
		System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1}));
		System.out.println(f.firstMissingPositive(new int[]{2,2}));
	}
}
