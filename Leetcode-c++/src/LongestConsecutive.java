import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
        if(num==null){
            return 0;
        }
        int max=0;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<num.length;++i){
            set.add(num[i]);
        }
        
        while(!set.isEmpty()){
        	int n=set.iterator().next();
        	int seq=1;
        	int i=1;
        	set.remove(n);
        	while(set.contains(n+i)){
        		seq++;
        		set.remove(n+i);
        		i++;
        	}
        	i=-1;
        	while(set.contains(n+i)){
        		seq++;
        		set.remove(n+i);
        		i--;
        	}
        	max=Math.max(max, seq);
        	
        }
        return max;
    }
	
	public static void main(String[] args) {
		LongestConsecutive l=new LongestConsecutive();
		System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(l.longestConsecutive(new int[]{100}));
		System.out.println(l.longestConsecutive(new int[]{0,-1}));
		System.out.println(l.longestConsecutive(new int[]{1,2,0,1}));


	}
}
