public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int length=strs.length;
		if(length==0){
			return "";
		}
		String max=strs[0];
		for (String string : strs) {
			max=longString(max, string);
		}
		return max;
	}
	
	private String longString(String s1,String s2){
		int l=Math.min(s1.length(), s2.length());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<l;++i){
			if(s1.charAt(i)==s2.charAt(i)){
				sb.append(s1.charAt(i));
			}else{
				break;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix l=new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(new String[]{"aca","cba"}));
	}
}
