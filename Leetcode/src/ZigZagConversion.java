public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(s == null || s.length()==0 || nRows <=0)
	        return "";
	    if(nRows == 1)
	        return s;
		StringBuilder sb = new StringBuilder();
		int size = 2 * nRows - 2;
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += size) {
				sb.append(s.charAt(j));
				if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length())
					sb.append(s.charAt(j + size - 2 * i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));
	}
}
