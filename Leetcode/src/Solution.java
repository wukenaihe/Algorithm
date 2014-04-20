import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public String reverseWords(String s) {
		// if(s.matches(" ")){
		// return " ";
		// }
		//
		// if(s.length()<2){
		// return "";
		// }
		//
		// String[] strs = s.split(" ");
		// StringBuilder strN = new StringBuilder();
		// if(s.substring(s.length()-2, s.length()-1).equals(" ")){
		// strN.append(" ");
		// }
		// for (int i = strs.length - 1; i >= 0; --i) {
		// strN.append(strs[i]);
		// if (i != 0) {
		// strN.append(" ");
		// }
		// }
		// if (s.substring(0, 1).equals(" ")) {
		// strN.append(" ");
		// }
		// return strN.toString();
		Stack<String> stack = new Stack<String>();
		String tokens[] = s.split(" ");
		int length = tokens.length;
		String reverseStr = "";

		for (int i = 0; i < length; i++) {

			if (tokens[i].equals(""))
				continue;
			// System.out.println(tokens[i] + "sssssssss");
			stack.push(tokens[i]);
		}

		while (!stack.isEmpty()) {

			String temp = stack.pop();
			if (reverseStr == "") {
				reverseStr = reverseStr.concat(temp);
			} else {
				reverseStr = reverseStr.concat(" ");
				reverseStr = reverseStr.concat(temp);
			}
		}

		return reverseStr;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseWords("  1"));
//		System.out.println(s.reverseWords(" ").length());
	}
}
