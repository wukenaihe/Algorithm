public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String maxStr = null;
		int max=0;
		for(int i=0;i<s.length();++i){
			int start=i;
			int end=i;
			int num=0;
			while(start>=0&&end<s.length()){
				if(s.charAt(start)!=s.charAt(end)){
					num=end-start-1;
					if(num>max){
						max=num;
						maxStr=s.substring(start+1,end);
					}
					break;
				}
				start--;
				end++;
			}
			num=end-start-1;
			if(num>max){
				max=num;
				maxStr=s.substring(start+1,end);
			}
			start=i;
			end=i+1;
			while(start>=0&&end<s.length()){
				if(s.charAt(start)!=s.charAt(end)){
					num=end-start-1;
					if(num>max){
						max=num;
						maxStr=s.substring(start+1,end);
					}
					break;
				}
				start--;
				end++;
			}
			num=end-start-1;
			if(num>max){
				max=num;
				maxStr=s.substring(start+1,end);
			}
		}
		return maxStr;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring l=new LongestPalindromicSubstring();
		
		System.out.println(l.longestPalindrome("abcddc"));
		System.out.println(l.longestPalindrome("a"));

	}
}
