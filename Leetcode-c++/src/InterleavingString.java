public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}else if((s1.length()==0&&s2.equals(s3))||(s2.length()==0&&s1.equals(s3))){
			return true;
		}else if(s1.length()==0||s2.length()==0){
			return false;
		}
		
		char c1=s1.charAt(0);
		char c2=s2.charAt(0);
		
		while(c1!=c2){
			if(c1==s3.charAt(0)){
				s1=s1.substring(1);
			}else if(c2==s3.charAt(0)){
				s2=s2.substring(1);
			}
			
			s3=s3.substring(1);
			
			if((s1.length()==0&&s2.equals(s3))||(s2.length()==0&&s1.equals(s3))){
				return true;
			}else if(s1.length()==0||s2.length()==0){
				return false;
			}
			
			c1=s1.charAt(0);
			c2=s2.charAt(0);
		}
		
		return isInterleave(s1.substring(1), s2, s3.substring(1))||isInterleave(s1, s2.substring(1), s3.substring(1));		
	}
	//动态规划，i,j表示s1(i),s2(j),是否等于s3(i+j)
	public boolean isInterleave2(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		int l1=s1.length();
		int l2=s2.length();
		boolean[][] match=new boolean[l1+1][l2+1];
		match[0][0]=true;
		
		for(int i=1;i<=l1;++i){
			if(s1.charAt(i-1)==s3.charAt(i-1)){
				match[i][0]=true;
			}else{
				break;
			}
		}
		
		for(int i=1;i<=l2;++i){
			if(s2.charAt(i-1)==s3.charAt(i-1)){
				match[0][i]=true;
			}else{
				break;
			}
		}
		
		for(int i=1;i<=l1;++i){
			char c1=s1.charAt(i-1);
			for(int j=1;j<=l2;++j){
				char c2=s2.charAt(j-1);
				char c3=s3.charAt(i+j-1);
				if(c1==c3){
					match[i][j]|=match[i-1][j];
				}
				
				if(c2==c3){
					match[i][j]|=match[i][j-1];
				}
			}
		}
		return match[l1][l2];
	}
	
	public static void main(String[] args) {
		InterleavingString i=new InterleavingString();
		
		System.out.println(i.isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(i.isInterleave2("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(i.isInterleave2("cacbbbaaabbacbbbbabbcaccccabaaacacbcaacababbaabbaccacbaabac", "cbcccabbbbaaacbaccbabaabbccbbbabacbaacccbbcaabaabbbcbcbab", "ccbcccacbabbbbbbaaaaabbaaccbabbbbacbcbcbaacccbacabbaccbaaabcacbbcabaabacbbcaacaccbbacaabababaabbbaccbbcacbbacabbaacb"));

		
	}
}
