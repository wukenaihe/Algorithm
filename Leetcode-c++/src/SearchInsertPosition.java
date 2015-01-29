public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int i=0,j=A.length-1;
		while(i<j){
			int mid=i+(j-i)/2;
			int num=A[mid];
			if(num==target){
				return mid;
			}else if(num<target){
				i=mid+1;
			}else{
				j=mid-1;
			}
		}
		if(A[i]<target){
			return i+1;
		}else{
			return i;
		}		
	}
	
	public static void main(String[] args) {
		SearchInsertPosition s=new SearchInsertPosition();
		System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));
		System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));
		System.out.println(s.searchInsert(new int[]{1,3,5,6}, 0));
	}
}
