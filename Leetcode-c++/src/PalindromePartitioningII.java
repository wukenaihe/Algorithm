import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningII {
//	Map<String, Integer> map=new HashMap<>();
//	public int minCut(String s) {
//		if(map.containsKey(s)){
//			return map.get(s);
//		}
//		if(isPalidrone(s, 0, s.length()-1)){
//			map.put(s, 0);
//			return 0;
//		}
//		int min=Integer.MAX_VALUE;
//		
//		for(int i=0;i<s.length();++i){
//			if(isPalidrone(s, 0, i)){
//				int num=minCut(s.substring(i+1))+1;
//				if(min>num){
//					min=num;
//				}
//			}
//		}
//		map.put(s, min);
//		return min;
//	}
	int[] minRecord;
	public int minCut(String s){
		if(s.length()==0){
			return 0;
		}
		minRecord=new int[s.length()];
		for(int i=0;i<s.length();++i){
			int min=Integer.MAX_VALUE;
			if(isPalidrone(s, 0, i)){
				minRecord[i]=0;
				continue;
			}else{
				for(int j=i;j>0;--j){
					if(isPalidrone(s, j, i)&&min>minRecord[j-1]+1){
						min=minRecord[j-1]+1;
					}
					if(min==1){
						break;
					}
				}
				minRecord[i]=min;
			}
		
		}
		return minRecord[s.length()-1];
	}
	
	private boolean isPalidrone(String s,int start,int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioningII p=new PalindromePartitioningII();
		System.out.println(p.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(p.minCut("aab"));
		System.out.println(p.minCut("abc"));
		System.out.println(p.minCut("a"));
	}
	
}
