import java.util.HashSet;
import java.util.Set;

public class Scramble {
	public boolean isScramble(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2) {
			return false;
		}

		if (s1.equals(s2)) {
			return true;
		}
		if (l1 == 1 && l2 == 1) {
			return false;
		}
		boolean ok=hasSame(s1, s2);
		if(!ok){
			return false;
		}
		for(int i=1;i<l1;++i){
			String sub21 = s2.substring(0, i);
			String sub22 = s2.substring(i);
			String sub11 = s1.substring(0, i);
			String sub12 = s1.substring(i);
			boolean r1 = isScramble(sub11, sub21) && isScramble(sub12, sub22);
			sub21=s2.substring(0,l2-i);
			sub22=s2.substring(l2-i);
			boolean r2 = isScramble(sub11, sub22)
					&& isScramble(sub12, sub21);
			if(r1||r2){
				return true;
			}
		}
		return false;

	}
	
	private boolean hasSame(String s1,String s2){
		int[] A=new int[26];
		for(int i=0;i<s1.length();++i){
			A[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();++i){
			A[s2.charAt(i)-'a']--;
		}
		for(int i=0;i<26;++i){
			if(A[i]!=0){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scramble s = new Scramble();
		System.out.println(s.isScramble("great", "rgeat"));
		System.out.println(s.isScramble("great", "rgtae"));
		System.out.println(s.isScramble("great", "rgtao"));
		System.out.println(s.isScramble("abc", "bac"));
		System.out.println(s.isScramble("ccbbcaccbccbbbcca", "ccbbcbbaabcccbccc"));
		System.out.println(s.isScramble("abc", "cab"));

	}
}
