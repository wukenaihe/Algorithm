import java.util.Arrays;

public class StrStr {
	public String strStr(String haystack, String needle) {
		int l1=haystack.length();
		int l2=needle.length();
		int start=0;
		boolean ok=false;
		while(l1-start>=l2){
			int i;
			for(i=0;i<l2;++i){
				if(haystack.charAt(start+i)!=needle.charAt(i)){
					break;
				}
			}
			if(i==l2){
				return haystack.substring(start);
			}
			start++;
		}
		return null;
	}
	

	
	public static void main(String[] args) {
		String a="abcde";
		String b="cdf";
		StrStr s=new StrStr();
		System.out.println(s.strStr(a, b));
		
	}
}
