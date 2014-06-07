import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {
	
	Map<String, List<String>> map=new HashMap<String, List<String>>();
	
	public List<String> anagrams(String[] strs) {
		int l=strs.length;
		for(int i=0;i<l;++i){
			String s=strs[i];
			char[] chars=s.toCharArray();
			Arrays.sort(chars);
			String e=new String(chars);
			if(map.containsKey(e)){
				List<String> list=map.get(e);
				list.add(s);
			}else{
				List<String> list=new ArrayList<String>();
				list.add(s);
				map.put(e, list);
			}
		}
		Set<String> keys=map.keySet();
		List<String> result=new ArrayList<String>();
		for (String string : keys) {
			List<String> r=map.get(string);
			if(r.size()>1){
				result.addAll(r);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Anagrams a=new Anagrams();
		System.out.println(a.anagrams(new String[]{"tea","and","ate","eat","den"}));
	}
}
