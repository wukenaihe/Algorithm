public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == '0') {
			return 0;
		}

		int[] number = new int[s.length() + 1];
		number[0] = 1;
		number[1] = 1;
		int tmp;
		for (int i = 2; i <= s.length(); i++) {
			tmp = Integer.parseInt(s.substring(i - 1, i));
			if (tmp != 0) {
				number[i] = number[i - 1];
			}
			if (s.charAt(i - 2) != '0') {
				tmp = Integer.parseInt(s.substring(i - 2, i));
				if (tmp > 0 && tmp <= 26) {
					number[i] += number[i - 2];
				}
			}
		}
		return number[s.length()];
	}

	public static void main(String[] args) {
		DecodeWays decodeWays = new DecodeWays();
		System.out.println(decodeWays.numDecodings("1012"));
	}
}
