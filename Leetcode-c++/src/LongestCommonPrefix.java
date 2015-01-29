public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        
        StringBuilder sb=new StringBuilder();
        int start=0;
        while(true){
            char c;
            if(strs[0]!=null&&start<strs[0].length()){
                c=strs[0].charAt(start);
            }else{
                return sb.toString();
            }
            for(int i=1;i<strs.length;++i){
                if(!(strs[i]!=null&&start<strs[i].length()&&strs[i].charAt(start)==c)){
                    return sb.toString();
                }
            }
            sb.append(c);
            start++;
        }
    }
	
	public static void main(String[] args) {
		LongestCommonPrefix l=new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(new String[]{"caca","cba"}));
	}
}
