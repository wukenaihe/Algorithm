public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        boolean[] tag=new boolean[256];
        int max=0,count=0;
        int start=0,end=0;
        while(end<s.length()){
            while(end<s.length()&&tag[s.charAt(end)]==false){
                count++;
                tag[s.charAt(end++)]=true;
            }
            max=max<count?count:max;
            while(end<s.length()&&s.charAt(end)!=s.charAt(start)){
                tag[s.charAt(start)]=false;
                start++;
                count--;
            }
            start++;
            end++;
        }
        return max;
    }

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();

		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
		System.out
				.println(l
						.lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
		System.out.println(l.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
		System.out.println(l.lengthOfLongestSubstring("bbb"));
		System.out.println(l.lengthOfLongestSubstring("whtaciohordtqkvwcsgspqo"));
	}
}
