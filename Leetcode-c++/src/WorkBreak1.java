import java.util.HashSet;
import java.util.Set;

public class WorkBreak1 {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s==null||dict==null){
            return false;
        }
        boolean[] res=new boolean[s.length()+1];
        res[0]=true;
        for(int i=0;i<s.length();++i){
            StringBuilder sb=new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j]&&dict.contains(sb.toString())){
                    res[i+1]=true;
                    break;
                }
                sb.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

	public static void main(String[] args) {
		WorkBreak1 wordBreak = new WorkBreak1();
		Set<String> dict = new HashSet<String>();
//		Collections.addAll(dict, "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
//
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//		boolean r = wordBreak.wordBreak(s, dict);
//		System.out.println(r);
		
		dict.add("a");
		System.out.println(wordBreak.wordBreak("a", dict));
	}
}
