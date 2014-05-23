import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	private String[] strs;
	private Map<Integer, List<String>> map=new HashMap<Integer, List<String>>();

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		int l1=s.length();
		int l2=dict.size();
		ArrayList<String> rs=new ArrayList<String>();
		strs=new String[dict.size()];
		int i=0;
		for (String string : dict) {
			strs[i++]=string;
		}
		boolean[][] result=parse(s, strs);
		List<String> list=get(0, result, l1, l2);
		return (ArrayList<String>)list;
	}
	
	private List<String> get(int start,boolean[][] result,int l1,int l2){
		if(map.get(start)!=null){
			return map.get(start);
		}
		List<String> list=new ArrayList<String>();
		String temp;
		for(int i=0;i<l2;++i){
			if(result[i][start]){
				int position=start+strs[i].length();
				List<String> temps;
				if(position==l1&&start!=0){
					temp=" "+strs[i];
					list.add(temp);
				}else if(position==l1){
					temp=strs[i];
					list.add(temp);
				}else if(position<l1){
					temps=get(position, result, l1, l2);
					for (String string : temps) {
						if(start==0){
							temp=strs[i]+string;
						}else{
							temp=" "+strs[i]+string;
						}
						list.add(temp);
					}
				}
				
			}
		}
		map.put(start, list);
		return list;
	}
	
	private boolean[][] parse(String s,String[] strs){
		int l1=s.length();
		int l2=strs.length;
		boolean[][] result=new boolean[l2][l1];
		for(int i=0;i<l2;++i){
			String str=strs[i];
			for(int j=0;j<=l1-str.length();++j){
				boolean ok=true;
				for(int k=0;k<str.length();++k){
					if(str.charAt(k)!=s.charAt(j+k)){
						ok=false;
						continue;
					}
				}
				result[i][j]=ok;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Set<String> dict=new HashSet<String>();
		Collections.addAll(dict, "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","b");
		WordBreak w=new WordBreak();
//		List<String> list=w.wordBreak("catsanddog", dict);
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(s.length());
		List<String>  list=w.wordBreak(s, dict);
		System.out.println(list);
		
	}
	
	private void print(boolean[][] result){
		for (int i = 0; i < result.length; i++) {
			System.out.print(strs[i]+" ");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
