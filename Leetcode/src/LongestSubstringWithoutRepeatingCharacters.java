public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int[] hash = new int[256];
		int max = 0;
		int temp = 0;
		int start = 0;
		int end = s.length();
		while (start < end) {
			char c = s.charAt(start);
			if (hash[c] != 0) {
				max = max < temp ? temp : max;
				start = hash[c];
				hash = new int[256];
				temp=0;
			} else {
				hash[c] = start+1;
				temp++;
				max = max < temp ? temp : max;
				start++;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();

		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
		System.out
				.println(l
						.lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
	}
}
