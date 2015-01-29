public class SearchRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int l=0,r=A.length-1;
		while(l<=r){
			int mid=(l+r)/2;
			if(A[mid]==target){
				return true;
			}
			
			if(A[l]>A[mid]){
				if(A[mid]<target&&A[r]>=target){
					l=mid+1;
				}else{
					r=mid-1;
				}
			}else if(A[l]<A[mid]){
				if(A[l]<=target&&A[mid]>target){
					r=mid-1;
				}else{
					l=mid+1;
				}
			}else{
				l=l+1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SearchRotatedSortedArrayII s=new SearchRotatedSortedArrayII();
		
		System.out.println(s.search(new int[]{1,1,1,1,2,3}, 4));
		System.out.println(s.search(new int[]{3,1,1}, 0));
		
	}
}
