public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        int length=s.length()*2;
        String maxStr="";
        for(int i=0;i<length;++i){
            int left=i/2;
            int right=i/2;
            if(i%2==1){
                right++;
            }
            
            String res=maxPalindrome(s,left,right);
            
            if(res.length()>maxStr.length()){
                maxStr=res;
            }
        }
        return maxStr;
        
    }
    
    private String maxPalindrome(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
	
	public static void main(String[] args) {
		LongestPalindromicSubstring l=new LongestPalindromicSubstring();
		
		System.out.println(l.longestPalindrome("abcddc"));
		System.out.println(l.longestPalindrome("a"));

	}
}
