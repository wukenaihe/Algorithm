
public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
        if(A==null){
            return -1;
        }
        
        int left=0,right=A.length-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(A[mid]==target){
                return mid;
            }
            
            if(A[mid]>=A[left]){
                if(A[mid]>target&&A[left]<=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(A[mid]<target&&A[right]>=target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		SearchinRotatedSortedArray s=new SearchinRotatedSortedArray();
//		System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
		System.out.println(s.search(new int[]{3,1}, 1));
	}
}
