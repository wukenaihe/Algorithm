import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result=new ArrayList<Integer>();
		if(L==null||L.length==0||S==null){
			return result;
		}
		int length=L[0].length();
		int sum=length*L.length;
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		for (String string : L) {
			Integer num=map.get(string);
			if(num==null){
				map.put(string, 1);
			}else{
				map.put(string, num+1);
			}
		}
		
		for(int i=0;i<S.length()-sum+1;++i){
			Map<String, Integer> currMap=new HashMap<String, Integer>();
			int count=0;
			for(int j=i;j<i+sum;j+=length){
				String s=S.substring(j,j+length);
				Integer n=map.get(s);
				if(n==null){
					break;
				}
				Integer cN=currMap.get(s);
				if(cN==null){
					currMap.put(s, 1);
					count++;
				}else if(n-cN>0){
					currMap.put(s, cN+1);
					count++;
				}else{
					break;
				}
			}
			if(count==L.length){
				result.add(i);
			}
		}
		
		
        return result;
    }
	
	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords s=new SubstringwithConcatenationofAllWords();
		
		System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
		System.out.println(s.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));

	}
}
