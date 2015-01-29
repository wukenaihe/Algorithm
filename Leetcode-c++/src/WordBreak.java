import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public List<String> wordBreak(String s, Set<String> dict) {
        if(s==null&&dict==null){
            return null;
        }
        List<String>[] lists=new List[s.length()+1];
        lists[0]=new ArrayList<String>();
        lists[0].add("");
        for(int i=0;i<s.length();++i){
            StringBuilder sb=new StringBuilder(s.substring(0,i+1));
            
            for(int j=0;j<=i;++j){
                if(lists[j]!=null&&dict.contains(sb.toString())){
                    if(lists[i+1]==null){
                        lists[i+1]=new ArrayList<String>();
                    }
                    List<String> res=lists[i+1];
                    List<String> list=lists[j];
                    for(String str:list){
                        if(str.equals("")){
                            res.add(sb.toString());
                        }else{
                            res.add(str+" "+sb.toString());
                        }
                    }
                }
                sb.deleteCharAt(0);
            }
            
        }
        return lists[s.length()];
    }
	
	public static void main(String[] args) {
		Set<String> dict=new HashSet<String>();
		Collections.addAll(dict, "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","b");
		WordBreak w=new WordBreak();
////		List<String> list=w.wordBreak("catsanddog", dict);
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(w.wordBreak(s, dict));
		
//		System.out.println(s.length());
//		Collections.addAll(dict, new String[]{"cat", "cats", "and", "sand", "dog"});
//		List<String>  list=w.wordBreak("catsanddog", dict);
//		System.out.println(list);
		
	}

}
