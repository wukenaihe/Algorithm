import java.util.Arrays;

public class SortColors {
	public void sortColors(int[] A) {
		int length=A.length;
		int a=0,b=0,c=0;
		for(int i=0;i<length;++i){
			int temp=A[i];
			if(temp==0){
				a++;
			}else if(temp==1){
				b++;
			}else{
				c++;
			}
		}
		for(int i=0;i<length;++i){
			if(i<a){
				A[i]=0;
			}else if(i>=a&&i<b+a){
				A[i]=1;
			}else{
				A[i]=2;
			}
		}
	}
	
	public void sort(int[] A){
		int length=A.length;
		int zeroEnd=0,twoStart=length-1;
		int i=0;
		while(i<=twoStart){
			if(A[i]==0&&i!=zeroEnd){
				swap(A, i, zeroEnd++);
			}else if(A[i]==2){
				swap(A, i, twoStart--);
			}else{
				i++;
			}
		}
	}
	
	private void swap(int[] A,int i,int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	public static void main(String[] args) {
		SortColors s=new SortColors();
		int[] A=new int[]{2};
		s.sort(A);
		System.out.println(Arrays.toString(A));
	}
}
