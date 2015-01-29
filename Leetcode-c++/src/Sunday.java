import java.util.HashMap;
import java.util.Map;


public class Sunday {
	public String strStr(String haystack, String needle) {
		if(haystack==null||needle==null||haystack.length()<needle.length()){
			return null;
		}
		int nLength=needle.length();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<needle.length();++i){
			map.put(needle.charAt(i), needle.length()-i);
		}
		int pos=0;
		while(pos<=haystack.length()-needle.length()){
			int i=0;
			for(int j=pos;i<nLength&&haystack.charAt(j)==needle.charAt(i);++i,++j);
			if(i==nLength){
				return haystack.substring(pos);
			}
			if(pos+nLength>=haystack.length()){
				return null;
			}
			char c=haystack.charAt(pos+nLength);
			pos+=map.get(c)==null?nLength:map.get(c);
		}
		
        return null;
    }
	public static void main(String[] args) {
		Sunday s=new Sunday();
		System.out.println(s.strStr("LESSONS TEARNED IN SOFTWARE TE", "SOFTWARE"));
	}
}
