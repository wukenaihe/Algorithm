import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int l=num.length-1;
		while(l>0){
			if(num[l]>num[l-1]){
				int min=l;
				for(int i=l+1;i<num.length;++i){
					if(num[i]>num[l-1]&&num[i]<num[min]){
						min=i;
					}
				}
				int temp=num[l-1];
				num[l-1]=num[min];
				num[min]=temp;
				sort(num,l);
				break;
			}
			l--;
		}
		if(l==0){
			sort(num,0);
		}
	}
	
	private void sort(int[] num,int start){
		for(int i=start+1;i<num.length;++i){
			int temp=num[i];
			int j=i;
			for(;j>start&&temp<num[j-1];--j){
				num[j]=num[j-1];
			}
			num[j]=temp;
		}
	}
	
	public static void main(String[] args) {
		NextPermutation n=new NextPermutation();
		int[] A=new int[]{1,2,3};
		n.nextPermutation(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{3,2,1};
		n.nextPermutation(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{1,1,5};
		n.nextPermutation(A);
		System.out.println(Arrays.toString(A));
	}
}
